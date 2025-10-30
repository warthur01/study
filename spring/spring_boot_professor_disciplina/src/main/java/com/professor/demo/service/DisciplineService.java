package com.professor.demo.service;

import com.professor.demo.entity.Discipline;
import com.professor.demo.entity.Professor;
import com.professor.demo.repository.DisciplineRepository;
import com.professor.demo.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineService {

    @Autowired
    private DisciplineRepository disciplineRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Discipline> findAll() {
        return disciplineRepository.findAll();
    }

    public Optional<Discipline> findById(Long id) {
        return disciplineRepository.findById(id);
    }

    public Discipline save(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    public Discipline update(Long id, Discipline updatedDiscipline) {
        Optional<Discipline> existingDiscipline = disciplineRepository.findById(id);
        if (existingDiscipline.isPresent()) {
            Discipline discipline = existingDiscipline.get();
            discipline.setName(updatedDiscipline.getName());
            discipline.setCode(updatedDiscipline.getCode());
            // Verify if the professor exists before updating
            if (updatedDiscipline.getProfessor() != null && updatedDiscipline.getProfessor().getId() != null) {
                Optional<Professor> professor = professorRepository.findById(updatedDiscipline.getProfessor().getId());
                if (professor.isPresent()) {
                    discipline.setProfessor(professor.get());
                } else {
                    throw new RuntimeException("Professor not found with ID: " + updatedDiscipline.getProfessor().getId());
                }
            }
            return disciplineRepository.save(discipline);
        } else {
            throw new RuntimeException("Discipline not found with ID: " + id);
        }
    }

    public void delete(Long id) {
        if (disciplineRepository.existsById(id)) {
            disciplineRepository.deleteById(id);
        } else {
            throw new RuntimeException("Discipline not found with ID: " + id);
        }
    }
}