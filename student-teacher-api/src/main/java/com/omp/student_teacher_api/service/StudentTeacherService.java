package com.omp.student_teacher_api.service;

import com.omp.student_teacher_api.entity.Student;
import com.omp.student_teacher_api.entity.StudentTeacher;
import com.omp.student_teacher_api.entity.Teacher;
import com.omp.student_teacher_api.repository.StudentRepository;
import com.omp.student_teacher_api.repository.StudentTeacherRepository;
import com.omp.student_teacher_api.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentTeacherService {
    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private TeacherRepository teacherRepo;

    @Autowired
    private StudentTeacherRepository stRepo;

    public StudentTeacher assign(Long studentId, Long teacherId) {
        Student student = studentRepo.findById(studentId).orElseThrow();
        Teacher teacher = teacherRepo.findById(teacherId).orElseThrow();

        StudentTeacher st = new StudentTeacher();
        st.setStudent(student);
        st.setTeacher(teacher);
        return stRepo.save(st);
    }

    public List<StudentTeacher> getAllAssignments() {
        return stRepo.findAll();
    }
}
