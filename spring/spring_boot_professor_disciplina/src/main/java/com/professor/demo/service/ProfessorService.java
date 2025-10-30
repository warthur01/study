package com.professor.demo.service;

import com.professor.demo.entity.Professor;
import com.professor.demo.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Optional<Professor> findById(Long id) {
        return professorRepository.findById(id);
    }

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor update(Long id, Professor updatedProfessor) {
        Optional<Professor> existingProfessor = professorRepository.findById(id);
        if (existingProfessor.isPresent()) {
            Professor professor = existingProfessor.get();
            professor.setName(updatedProfessor.getName());
            professor.setDepartment(updatedProfessor.getDepartment());
            // Disciplines are not updated directly here to avoid issues with relationships
            return professorRepository.save(professor);
        } else {
            throw new RuntimeException("Professor not found with ID: " + id);
        }
    }

    public void delete(Long id) {
        if (professorRepository.existsById(id)) {
            professorRepository.deleteById(id);
        } else {
            throw new RuntimeException("Professor not found with ID: " + id);
        }
    }
}