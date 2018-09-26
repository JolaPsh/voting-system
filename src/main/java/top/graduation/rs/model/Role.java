package top.graduation.rs.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */
public enum Role implements GrantedAuthority {
    ROLE_USER,
    ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
