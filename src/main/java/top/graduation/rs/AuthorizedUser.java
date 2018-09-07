package top.graduation.rs;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */
public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    public AuthorizedUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}