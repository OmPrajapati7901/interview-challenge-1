package com.omp.student_teacher_api.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class StudentTeacherDTO {

    private Long studentId;
    private Long teacherId;
    private LocalDate joinedAt;


}
