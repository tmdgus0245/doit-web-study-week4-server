package doit.week4server.controller;

import doit.week4server.controller.dto.AuthLoginRequest;
import doit.week4server.controller.dto.AuthLoginResponse;
import doit.week4server.controller.dto.AuthSignUpRequest;
import doit.week4server.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    // 아이디 중복 체크
    @GetMapping("/auth/students/validate")
    public void validateLoginId(@RequestParam String studentLoginId) {
        authService.validateLoginId(studentLoginId);
    }

    // 회원가입
    @PostMapping("/auth/students")
    public AuthLoginResponse signUp(@RequestBody AuthSignUpRequest request) {
        return authService.signUp(request);
    }

    // 로그인
    @PostMapping("/auth/students/login")
    public AuthLoginResponse login(@RequestBody AuthLoginRequest request) {
        return authService.login(request);
    }


}