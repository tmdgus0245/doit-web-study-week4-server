package doit.week4server.service;

import doit.week4server.controller.dto.*;
import doit.week4server.repository.Student;
import doit.week4server.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthService {

    private final StudentRepository studentRepository;

    // 아이디 중복 체크
    public void validateLoginId(String studentLoginId) {
        Student student = studentRepository.findByStudentLoginId(studentLoginId);

        if (student != null) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
    }

    //회원가입
    public AuthLoginResponse signUp(AuthSignUpRequest request) {
        if (studentRepository.findByStudentLoginId(request.getStudentLoginId()) != null) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        Student student = Student.builder()
                .studentName(request.getStudentName())
                .studentNickname(request.getStudentNickname())
                .studentBirthday(request.getStudentBirthday())
                .studentLoginId(request.getStudentLoginId())
                .studentPassword(request.getStudentPassword())
                .build();

        Student savedStudent = studentRepository.save(student);
        return AuthLoginResponse.from(savedStudent);
    }

    //로그인
    public AuthLoginResponse login(AuthLoginRequest request) {
        Student student = studentRepository.findByStudentLoginIdAndStudentPassword(
                request.getStudentLoginId(), request.getStudentPassword());

        if (student == null) {
            throw new IllegalArgumentException("일치하는 회원이 없습니다.");
        }

        return AuthLoginResponse.from(student);
    }
}