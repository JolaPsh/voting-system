package top.graduation.rs.web;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */
public class SecurityUtil {

    private SecurityUtil() {
    }

  /*  public static AuthorizedUser safeGet() {
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

    public static int authUserId() {
        return get().getUser().getId();
    }*/
}
