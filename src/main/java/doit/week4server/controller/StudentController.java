package doit.week4server.controller;

import doit.week4server.controller.dto.AuthPasswordChangeRequest;
import doit.week4server.controller.dto.StudentNicknameChangeRequest;
import doit.week4server.controller.dto.StudentResponse;
import doit.week4server.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    //회원 정보 조회
    @GetMapping("/students/{studentId}")
    public StudentResponse findOneStudent(@PathVariable Long studentId) {
        return studentService.findOneStudent(studentId);
    }

    // 전체 회원 정보 조회
    @GetMapping("/students")
    public List<StudentResponse> findAllStudents() {
        return studentService.findAllStudents();
    }

    //회원 이름으로 회원 정보 조회
    @GetMapping("/students/search")
    public List<StudentResponse> searchStudents(@RequestParam String studentName) {
        return studentService.searchStudentsWithName(studentName);
    }

    // 회원 비밀번호 변경
    @PostMapping("/students/{studentId}/password")
    public void changePassword(@PathVariable Long studentId, @RequestBody AuthPasswordChangeRequest request) {
        studentService.changePassword(studentId, request);
    }

    @PostMapping("/students/{studentId}/nickname")
    public void changePassword(@PathVariable Long studentId, @RequestBody StudentNicknameChangeRequest request) {
        studentService.changeNickname(studentId, request);
    }

    // 회원 중 Nickname으로 회원 정보 조회
    @GetMapping("/students/nickname")
    public  List<StudentResponse> searchStudentsByBirthday(@RequestParam String studentNickname) {
        return studentService.searchStudentsWithNickname(studentNickname);
    }
}
