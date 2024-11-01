package doit.week4server.controller.dto;

import doit.week4server.repository.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthLoginResponse {
    private Long id;
    private String memberName;

    public static AuthLoginResponse from(User user) {
        return AuthLoginResponse.builder()
                .id(user.getId())
                .memberName(user.getUserName())
                .build();
    }
}
