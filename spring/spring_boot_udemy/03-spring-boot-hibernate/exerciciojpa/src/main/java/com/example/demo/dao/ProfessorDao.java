package com.example.demo.dao;

import com.example.demo.entity.Professor;

public interface ProfessorDao {

    public void createProfessor(Professor professor);
    public Professor findProfessorById(int id);
}
