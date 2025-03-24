package com.omp.student_teacher_api.controller;


import com.omp.student_teacher_api.entity.StudentTeacher;
import com.omp.student_teacher_api.service.StudentTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignments")
public class StudentTeacherController {

    @Autowired
    private StudentTeacherService service;

    @PostMapping
    public ResponseEntity<StudentTeacher> assign(@RequestParam Long studentId, @RequestParam Long teacherId) {
        return ResponseEntity.ok(service.assign(studentId, teacherId));
    }

    @GetMapping
    public ResponseEntity<List<StudentTeacher>> getAll() {
        return ResponseEntity.ok(service.getAllAssignments());
    }
}
