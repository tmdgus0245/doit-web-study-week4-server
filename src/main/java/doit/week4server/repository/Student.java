package doit.week4server.repository;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id")
    private Long id;
    private String studentName;
    private String studentNickname;
    private LocalDate studentBirthday;
    private String studentLoginId;
    private String studentPassword;

    @Builder
    private Student(String studentName, String studentNickname, LocalDate studentBirthday, String studentLoginId, String studentPassword) {
        this.studentName = studentName;
        this.studentNickname = studentNickname;
        this.studentBirthday = studentBirthday;
        this.studentLoginId = studentLoginId;
        this.studentPassword = studentPassword;
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (!studentPassword.equals(oldPassword)) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        studentPassword = newPassword;
    }

    public void changeNickname(String newNickname, String password) {
        if (!studentPassword.equals(password)) {
            throw new RuntimeException("비밀번호가 일치하지 않습니다.");
        }
        studentNickname = newNickname;
    }
}
