package com.omp.student_teacher_api.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class Student {

    @Id @GeneratedValue
    private Long id;
    private String name;

    private String email;
    private int grade;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<StudentTeacher> studentTeachers = new HashSet<>();





//
//    public String getName() {
//        return name;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public int getGrade() {
//        return grade;
//    }
//
//    public void setGrade(int grade) {
//        this.grade = grade;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<StudentTeacher> getStudentTeachers() {
//        return studentTeachers;
//    }
//
//    public void setStudentTeachers(List<StudentTeacher> studentTeachers) {
//        this.studentTeachers = studentTeachers;
//    }
}
