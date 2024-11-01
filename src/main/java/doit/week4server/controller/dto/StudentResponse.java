package doit.week4server.controller.dto;

import doit.week4server.repository.Student;
import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentResponse {
    private Long id;
    private String studentName;
    private String studentNickname;
    private LocalDate studentBirthday;
    private String studentLoginId;

    public static StudentResponse from(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .studentName(student.getStudentName())
                .studentNickname(student.getStudentNickname())
                .studentBirthday(student.getStudentBirthday())
                .studentLoginId(student.getStudentLoginId())
                .build();
    }
}