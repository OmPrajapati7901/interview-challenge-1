package com.omp.student_teacher_api.repository;

import com.omp.student_teacher_api.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
