package com.omp.student_teacher_api.service;

import com.omp.student_teacher_api.entity.Student;
import com.omp.student_teacher_api.exception.ResourceNotFoundException;
import com.omp.student_teacher_api.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepo;

    @Transactional
    public Student saveStudent(Student student) {

        logger.info("Attempting to save student: {}", student);
        Student savedStudent = studentRepo.save(student);
        logger.info("Successfully saved student with ID: {}", savedStudent.getId());
        return savedStudent;
    }

    public List<Student> getAllStudents() {
        logger.info("Fetching all students");
        List<Student> students = studentRepo.findAll();
        logger.info("Retrieved {} students", students.size());
        return students;
    }

    public Student  getStudentById(Long id) {
        logger.info("Fetching student by ID: {}", id);
        return studentRepo.findById(id)
                .orElseThrow(() -> {
                    logger.error("Student not found with ID: {}", id);
                    return new ResourceNotFoundException("Student not found with ID: " + id);
                });
    }
}
