package com.omp.student_teacher_api.service;


import com.omp.student_teacher_api.dto.TeacherResponseDTO;
import com.omp.student_teacher_api.entity.Teacher;
import com.omp.student_teacher_api.repository.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepo;

    @Transactional
    public TeacherResponseDTO saveTeacher(Teacher teacher){

        return new TeacherResponseDTO(teacherRepo.save(teacher));
    }

    public List<TeacherResponseDTO> getAllTeachers(){return teacherRepo.findAll().stream()
            .map(TeacherResponseDTO::new)
            .collect(Collectors.toList());
    }

    public TeacherResponseDTO getTeacherById(Long id){
        Teacher teacher = teacherRepo.findById(id).orElseThrow();
        return new TeacherResponseDTO(teacher);
    }
}
