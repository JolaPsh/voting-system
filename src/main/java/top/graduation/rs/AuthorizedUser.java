package top.graduation.rs;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import top.graduation.rs.model.User;

import static java.util.Objects.requireNonNull;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */
public class AuthorizedUser extends org.springframework.security.core.userdetails.User {
    private static final long serialVersionUID = 1L;

    private User user;

    public AuthorizedUser(User user) {
        super(user.getEmail(), user.getPassword(), user.isEnabled(), true, true, true, user.getRoles());
        this.user = user; //new User(user.getId(), user.getName(),  user.getEmail(), user.getRegistered(), user.getPassword(), user.isEnabled(), user.getRoles());
    }

    public static AuthorizedUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        return (principal instanceof AuthorizedUser) ? (AuthorizedUser) principal : null;
    }

    public static AuthorizedUser get() {
        AuthorizedUser user = safeGet();
        requireNonNull(user, "No authorized user found");
        return user;
    }

    public static int id() {
        return get().user.getId();
    }

    @Override
    public String toString() {
        return "AuthorizedUser{" +
                "user=" + user.getId() + user.getName() + user.getPassword() +
                '}';
    }

    /*  public int getId() {
        return user.getId();
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return user.toString();
    }*/
}