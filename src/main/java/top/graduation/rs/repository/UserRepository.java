package top.graduation.rs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.graduation.rs.model.User;

import java.util.List;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */
public interface UserRepository extends JpaRepository {
    // null if not found
    User get(int id);

    User save(User user);

    // false if not found
    boolean delete(int id);

    // null if not found
    User getByEmail(String email);

    List<User> getAll();

    default User test(int id) {
        throw new UnsupportedOperationException();
    }
}
