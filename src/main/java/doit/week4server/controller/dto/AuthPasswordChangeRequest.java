package doit.week4server.controller.dto;

import lombok.Data;

@Data
public class AuthPasswordChangeRequest {
    private String oldPassword;
    private String newPassword;
}

