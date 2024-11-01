package doit.week4server.repository;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    private String userName;
    private String userNickname;
    private LocalDate userBirthday;
    private String userLoginId;
    private String userPassword;

    @Builder
    private User(String userName, String userNickname, LocalDate userBirthday, String userLoginId, String userPassword) {
        this.userName = userName;
        this.userNickname = userNickname;
        this.userBirthday = userBirthday;
        this.userLoginId = userLoginId;
        this.userPassword = userPassword;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (!userPassword.equals(oldPassword)) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        userPassword = newPassword;
    }

    public void changeNickname(String newNickname, String password) {
        if (!userPassword.equals(password)) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        userNickname = newNickname;
    }
}
