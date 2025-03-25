package com.omp.student_teacher_api.dto;

import com.omp.student_teacher_api.enums.UserRole;

public record SignUpDto(String login,
                        String password,
                        UserRole role) {
}
