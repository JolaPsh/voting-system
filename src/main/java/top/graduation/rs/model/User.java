package top.graduation.rs.model;

import java.time.LocalDate;
import java.util.Set;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */
public class User {
    private final Integer id;
    private final String name;
    private final String email;
    private final LocalDate registered;
    private final String password;
    private final Set<Role> roles;
    private final Set<Vote> userVotes;

    public User(Integer id, String name, String email, LocalDate registered, String password, Set<Role> roles, Set<Vote> userVotes) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.registered = registered;
        this.password = password;
        this.roles = roles;
        this.userVotes = userVotes;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getRegistered() {
        return registered;
    }

    public String getPassword() {
        return password;
    }

    public Set<Vote> getUserVotes() {
        return userVotes;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
