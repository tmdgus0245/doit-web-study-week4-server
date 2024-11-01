package doit.week4server.service;

import doit.week4server.controller.dto.AuthPasswordChangeRequest;
import doit.week4server.controller.dto.StudentNicknameChangeRequest;
import doit.week4server.controller.dto.StudentResponse;
import doit.week4server.repository.Student;
import doit.week4server.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentResponse findOneStudent(Long studentId) {
        Optional<Student> student = studentRepository.findById(studentId);
        if (student.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }
        return StudentResponse.from(student.get());
    }

    // 전체 회원 정보 조회
    public List<StudentResponse> findAllStudents() {
        List<Student> students = studentRepository.findAll();

        return students.stream()
                .map(StudentResponse::from)
                .toList();
    }

    // 회원 이름으로 회원 정보 조회
    public List<StudentResponse> searchStudentsWithName(String studentName) {
        // DB에서 studentName에 해당하는 회원 정보를 조회한다.
        List<Student> students = studentRepository.findByStudentName(studentName);

        // 조회된 회원 정보를 List<StudentResponse>로 변환하여 반환한다.
        return students.stream()
                .map(StudentResponse::from)
                .toList();
    }

    // 회원 비밀번호 변경
    public void changePassword(Long studentId, AuthPasswordChangeRequest request) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        student.changePassword(request.getOldPassword(), request.getNewPassword());

        studentRepository.save(student);
    }

    public List<StudentResponse> searchStudentsWithNickname(String studentNickname) {
        List<Student> students = studentRepository.findByStudentNickname(studentNickname);

        return students.stream()
                .map(StudentResponse::from)
                .toList();
    }

    public void changeNickname(Long studentId, StudentNicknameChangeRequest request) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        student.changeNickname(request.getNewNickname(), request.getPassword());

        studentRepository.save(student);
    }
}
