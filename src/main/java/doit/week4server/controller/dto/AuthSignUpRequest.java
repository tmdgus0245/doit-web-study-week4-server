package doit.week4server.controller.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class AuthSignUpRequest {
    private String userName;
    private LocalDate userBirthday;
    private String userNickname;
    private String userLoginId;
    private String userPassword;
}