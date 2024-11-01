package doit.week4server.controller.dto;

import lombok.Data;

@Data
public class AuthLoginRequest {
    private String studentLoginId;
    private String studentPassword;
}