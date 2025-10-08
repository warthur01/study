package com.example.demo.dao;

import com.example.demo.entity.Professor;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProfessorDaoImp implements ProfessorDao {
    private EntityManager entityManager;

    @Autowired
    public ProfessorDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createProfessor(Professor professor) {
        entityManager.persist(professor);
    }

    @Override
    public Professor findProfessorById(int id) {
        return entityManager.find(Professor.class ,id);
    }
}

