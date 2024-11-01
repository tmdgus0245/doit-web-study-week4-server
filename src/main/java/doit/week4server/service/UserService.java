package doit.week4server.service;

import doit.week4server.controller.dto.AuthPasswordChangeRequest;
import doit.week4server.controller.dto.UserNicknameChangeRequest;
import doit.week4server.controller.dto.UserResponse;
import doit.week4server.repository.User;
import doit.week4server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.fileupload.util.LimitedInputStream;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse findOneUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }
        return UserResponse.from(user.get());
    }

    // 전체 회원 정보 조회
    public List<UserResponse> findAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(UserResponse::from)
                .toList();
    }

    // 회원 이름으로 회원 정보 조회
    public List<UserResponse> searchUsersWithName(String userName) {
        // DB에서 userName에 해당하는 회원 정보를 조회한다.
        List<User> users = userRepository.findByUserName(userName);

        // 조회된 회원 정보를 List<UserResponse>로 변환하여 반환한다.
        return users.stream()
                .map(UserResponse::from)
                .toList();
    }

    // 회원 비밀번호 변경
    public void changePassword(Long userId, AuthPasswordChangeRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        user.changePassword(request.getOldPassword(), request.getNewPassword());

        userRepository.save(user);
    }

    public List<UserResponse> searchUsersWithNickname(String userNickname) {
        List<User> users = userRepository.findByUserNickname(userNickname);

        return users.stream()
                .map(UserResponse::from)
                .toList();
    }

    public void changeNickname(Long userId, UserNicknameChangeRequest request) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        user.changeNickname(request.getNewNickname(), request.getPassword());

        userRepository.save(user);
    }
}
