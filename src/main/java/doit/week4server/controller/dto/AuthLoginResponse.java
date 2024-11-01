package doit.week4server.controller.dto;

import doit.week4server.repository.Student;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthLoginResponse {
    private Long id;
    private String studentName;

    public static AuthLoginResponse from(Student student) {
        return AuthLoginResponse.builder()
                .id(student.getId())
                .studentName(student.getStudentName())
                .build();
    }
}
