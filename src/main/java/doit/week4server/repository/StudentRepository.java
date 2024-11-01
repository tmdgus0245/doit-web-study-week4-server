package doit.week4server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findByStudentLoginId(String studentLoginId);

    List<Student> findByStudentName(String studentName);

    Student findByStudentLoginIdAndStudentPassword(String studentLoginId, String studentPassword);

    List<Student> findByStudentNickname(String Nickname);
}