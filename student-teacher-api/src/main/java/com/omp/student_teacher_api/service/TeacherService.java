package com.omp.student_teacher_api.service;


import com.omp.student_teacher_api.entity.Teacher;
import com.omp.student_teacher_api.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepo;

    @Transactional
    public Teacher saveTeacher(Teacher teacher){
        return teacherRepo.save(teacher);
    }

    public List<Teacher> getAllTeachers(){return teacherRepo.findAll();
    }

    public Optional<Teacher> getTeacherById(Long id){
        return teacherRepo.findById(id);
    }
}
