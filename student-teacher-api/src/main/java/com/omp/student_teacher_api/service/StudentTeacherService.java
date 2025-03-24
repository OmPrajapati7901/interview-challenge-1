package com.omp.student_teacher_api.service;

import com.omp.student_teacher_api.entity.Student;
import com.omp.student_teacher_api.entity.StudentTeacher;
import com.omp.student_teacher_api.entity.Teacher;
import com.omp.student_teacher_api.exception.ResourceNotFoundException;
import com.omp.student_teacher_api.repository.StudentRepository;
import com.omp.student_teacher_api.repository.StudentTeacherRepository;
import com.omp.student_teacher_api.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentTeacherService {


    private static final Logger logger = LoggerFactory.getLogger(StudentTeacherService.class);

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private TeacherRepository teacherRepo;

    @Autowired
    private StudentTeacherRepository stRepo;

    @Transactional
    public StudentTeacher assign(Long studentId, Long teacherId) {
        Student student = studentRepo.findById(studentId).orElseThrow(() ->{
                logger.error("Student not found with ID: {}", studentId);
                return new ResourceNotFoundException("Student not found with id: " + studentId);
        });


        Teacher teacher = teacherRepo.findById(teacherId).orElseThrow(() -> {
                    logger.error("Teacher not found with ID: {}", teacherId);

                    return new ResourceNotFoundException("Teacher not found with id: " + teacherId);}
                );


        StudentTeacher st = new StudentTeacher();
        st.setStudent(student);
        st.setTeacher(teacher);
        return stRepo.save(st);
    }

    public List<StudentTeacher> getAllAssignments() {

        logger.info("Fetching all student-teacher assignments");
        return stRepo.findAll();
    }
}
