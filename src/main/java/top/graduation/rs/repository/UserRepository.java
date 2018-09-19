package top.graduation.rs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.graduation.rs.model.User;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserByEmail(String email);
}
