package doit.week4server.controller.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AuthSignUpRequest {
    private String studentName;
    private String studentNickname;
    private LocalDate studentBirthday;
    private String studentLoginId;
    private String studentPassword;
}