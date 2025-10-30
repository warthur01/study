package com.professor.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "professors")
@Data
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String department;

    @OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Discipline> disciplines = new ArrayList<>();
}