package doit.week4server.controller.dto;

import doit.week4server.repository.User;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private Long id;
    private String userName;
    private String userNickname;
    private LocalDate userBirthday;
    private String userLoginId;

    public static UserResponse from(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .userNickname(user.getUserNickname())
                .userBirthday(user.getUserBirthday())
                .userLoginId(user.getUserLoginId())
                .build();
    }
}