package com.omp.student_teacher_api.service;

import com.omp.student_teacher_api.dto.StudentResponseDTO;
import com.omp.student_teacher_api.entity.Student;
import com.omp.student_teacher_api.exception.ResourceNotFoundException;
import com.omp.student_teacher_api.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepo;

    @Transactional
    public StudentResponseDTO saveStudent(Student student) {

        logger.info("Attempting to save student: {}", student);
        Student savedStudent = studentRepo.save(student);
        logger.info("Successfully saved student with ID: {}", savedStudent.getId());
        return new StudentResponseDTO(savedStudent);
    }

    public List<StudentResponseDTO> getAllStudents() {
        logger.info("Fetching all students");
        List<StudentResponseDTO> students = studentRepo.findAll().stream()
                .map(StudentResponseDTO::new)
                .collect(Collectors.toList());
        logger.info("Retrieved {} students", students.size());
        return students;
    }

    public StudentResponseDTO getStudentById(Long id) {
        logger.info("Fetching student by ID: {}", id);
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> {
                    logger.error("Student not found with ID: {}", id);
                    return new ResourceNotFoundException("Student not found with ID: " + id);
                });

        return new StudentResponseDTO(student);
    }
}
