package doit.week4server.controller;

import doit.week4server.controller.dto.AuthPasswordChangeRequest;
import doit.week4server.controller.dto.UserNicknameChangeRequest;
import doit.week4server.controller.dto.UserResponse;
import doit.week4server.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 회원 정보를 조회한다.
     */
    @GetMapping("/users/{userId}")
    public UserResponse findOneUser(@PathVariable Long userId) {
        return userService.findOneUser(userId);
    }

    /**
     * 전체 회원 정보를 조회한다.
     */
    @GetMapping("/users")
    public List<UserResponse> findAllUsers() {
        return userService.findAllUsers();
    }

    /**
     * 회원 이름으로 회원 정보를 조회한다.
     */
    @GetMapping("/users/search")
    public List<UserResponse> searchUsers(@RequestParam String userName) {
        return userService.searchUsersWithName(userName);
    }

    /**
     * 회원 비밀번호를 변경한다.
     */
    @PostMapping("/users/{userId}/password")
    public void changePassword(@PathVariable Long userId, @RequestBody AuthPasswordChangeRequest request) {
        userService.changePassword(userId, request);
    }

    @PostMapping("/users/{userId}/nickname")
    public void changePassword(@PathVariable Long userId, @RequestBody UserNicknameChangeRequest request) {
        userService.changeNickname(userId, request);
    }

    // TODO : 자유 주제로 API를 추가로 구현해보세요.
    /**
     * 회원 중 Nickname으로 회원 정보를 조회한다.
     */
    @GetMapping("/users/nickname")
    public  List<UserResponse> searchUsersByBirthday(@RequestParam String userNickname) {
        return userService.searchUsersWithNickname(userNickname);
    }
}
