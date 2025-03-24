package com.omp.student_teacher_api.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id @GeneratedValue
    private Long id;
    private String name;

    private String email;
    private int grade;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<StudentTeacher> studentTeachers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
