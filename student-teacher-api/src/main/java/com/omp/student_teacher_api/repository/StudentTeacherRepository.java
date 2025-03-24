package com.omp.student_teacher_api.repository;

import com.omp.student_teacher_api.entity.StudentTeacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentTeacherRepository extends JpaRepository<StudentTeacher, Long> {
}
