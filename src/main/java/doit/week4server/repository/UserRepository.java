package doit.week4server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserLoginId(String userLoginId);

    List<User> findByUserName(String userName);

    User findByUserLoginIdAndUserPassword(String userLoginId, String userPassword);

    List<User> findByUserNickname(String Nickname);
}