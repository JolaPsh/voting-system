package top.graduation.rs.repository;

import top.graduation.rs.model.User;

import java.util.List;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */
public interface UserRepository {

    User get(int id);

    User save(User user);

    boolean delete(int id);

    User getByEmail(String email);

    List<User> getAll();

    default User test(int id) {
        throw new UnsupportedOperationException();
    }
}
