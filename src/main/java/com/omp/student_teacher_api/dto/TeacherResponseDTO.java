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
public class TeacherResponseDTO {
    private Long id;
    private String name;
    private List<StudentSummary> students;

    public TeacherResponseDTO() {}

    public TeacherResponseDTO(Teacher teacher) {
        this.id = teacher.getId();
        this.name = teacher.getName();
        this.students = teacher.getStudentTeachers().stream()
            .map(st -> new StudentSummary(st.getStudent(), st.getJoinedAt()))
            .collect(Collectors.toList());
    }

    @Getter
    @Setter
    public static class StudentSummary {
        private Long id;
        private String name;
        private LocalDate joinedAt;

        public StudentSummary() {}
        public StudentSummary(Student student, LocalDate joinedAt) {
            this.id = student.getId();
            this.name = student.getName();
            this.joinedAt = joinedAt;
        }
    }
}
