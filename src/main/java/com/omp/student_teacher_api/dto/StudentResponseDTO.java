package com.omp.student_teacher_api.dto;

import com.omp.student_teacher_api.entity.Student;
import com.omp.student_teacher_api.entity.Teacher;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class StudentResponseDTO {
    private Long id;
    private String name;
    private String email;
    private int grade;
    private List<TeacherSummary> teachers;


    public StudentResponseDTO() {}

    public StudentResponseDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.grade = student.getGrade();
        this.teachers = student.getStudentTeachers().stream()
            .map(st -> new TeacherSummary(st.getTeacher(), st.getJoinedAt()))
            .collect(Collectors.toList());
    }

    @Getter
    @Setter
    public static class TeacherSummary {
        private Long id;
        private String name;
        private LocalDate joinedAt;

        public TeacherSummary() {}

        public TeacherSummary(Teacher teacher, LocalDate joinedAt) {
            this.id = teacher.getId();
            this.name = teacher.getName();
            this.joinedAt = joinedAt;
        }
    }
}
