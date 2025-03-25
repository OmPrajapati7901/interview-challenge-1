package com.omp.student_teacher_api.controller;



import com.omp.student_teacher_api.service.StudentTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/assignments")
public class StudentTeacherController {

    @Autowired
    private StudentTeacherService service;

    @PostMapping
    public ResponseEntity<String> assign(@RequestParam Long studentId, @RequestParam Long teacherId) {
        return ResponseEntity.ok(service.assign(studentId, teacherId));
    }

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getAll() {
        return ResponseEntity.ok(service.getAllAssignments());
    }
}
