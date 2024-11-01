package doit.week4server.controller.dto;

import lombok.Data;

@Data
public class StudentNicknameChangeRequest {
    private String newNickname;
    private String password;
}