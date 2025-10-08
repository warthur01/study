package com.example.demo.runner;

import com.example.demo.dao.ProfessorDao;
import com.example.demo.entity.Professor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    private ProfessorDao professorDao;

    @Autowired
    public Runner(ProfessorDao dao) {
        this.professorDao = dao;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("dentro da classe Runner");
        buildProfessors();
       Professor p = professorDao.findProfessorById(1);
        System.out.println(p.getName());

    }

    public void buildProfessors() {
        Professor michel = new Professor("michel");
        Professor arthur = new Professor("arthur");
        Professor aline = new Professor("aline");

        professorDao.createProfessor(michel);
        professorDao.createProfessor(arthur);
        professorDao.createProfessor(aline);
    }
}
