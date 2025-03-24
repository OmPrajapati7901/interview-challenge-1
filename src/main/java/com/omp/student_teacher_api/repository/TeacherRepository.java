package com.omp.student_teacher_api.repository;

import com.omp.student_teacher_api.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
}
