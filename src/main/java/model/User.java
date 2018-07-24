package model;

import java.util.Set;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */
public class User {
    private final Integer id;
    private final String name;
    private final Set<Role> roles;

    public User(Integer id, String name, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Role> getRoles() {
        return roles;
    }
}
