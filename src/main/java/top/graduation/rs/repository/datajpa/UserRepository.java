package top.graduation.rs.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import top.graduation.rs.model.User;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u FROM User u LEFT JOIN u.roles WHERE u.email=:email")
    User findByEmail(@Param("email") String email);
}
