package com.omp.student_teacher_api.controller;


import com.omp.student_teacher_api.dto.TeacherResponseDTO;
import com.omp.student_teacher_api.entity.Teacher;
import com.omp.student_teacher_api.repository.TeacherRepository;
import com.omp.student_teacher_api.service.TeacherService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @PostMapping
    public ResponseEntity<TeacherResponseDTO> createTeacher(@RequestBody Teacher teacher) {
        return ResponseEntity.ok(service.saveTeacher(teacher));
    }

    @GetMapping
    public ResponseEntity<List<TeacherResponseDTO>> getAllTeachers() {
        return ResponseEntity.ok(service.getAllTeachers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherResponseDTO> getTeacherById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTeacherById(id));

    }
}
