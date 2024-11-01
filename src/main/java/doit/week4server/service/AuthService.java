package doit.week4server.service;

import doit.week4server.controller.dto.*;
import doit.week4server.repository.User;
import doit.week4server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    // 아이디 중복 체크
    public void validateLoginId(String userLoginId) {
        User user = userRepository.findByUserLoginId(userLoginId);

        if (user != null) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
    }

    //회원가입
    public AuthLoginResponse signUp(AuthSignUpRequest request) {
        if (userRepository.findByUserLoginId(request.getUserLoginId()) != null) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        User user = User.builder()
                .userName(request.getUserName())
                .userNickname(request.getUserNickname())
                .userBirthday(request.getUserBirthday())
                .userLoginId(request.getUserLoginId())
                .userPassword(request.getUserPassword())
                .build();

        User savedUser = userRepository.save(user);
        return AuthLoginResponse.from(savedUser);
    }

    //로그인
    public AuthLoginResponse login(AuthLoginRequest request) {
        User user = userRepository.findByUserLoginIdAndUserPassword(
                request.getUserLoginId(), request.getUserPassword());

        if (user == null) {
            throw new IllegalArgumentException("일치하는 회원이 없습니다.");
        }

        return AuthLoginResponse.from(user);
    }
}