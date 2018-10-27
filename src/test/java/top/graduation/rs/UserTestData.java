package top.graduation.rs;

import top.graduation.rs.model.Role;
import top.graduation.rs.model.User;

import static top.graduation.rs.model.AbstractBaseEntity.START_SEQ;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */
public class UserTestData {
    public static final int USER1_ID = START_SEQ + 17;
    public static final int USER2_ID = START_SEQ + 18;
    public static final int ADMIN_ID = START_SEQ + 16;

    public static final User ADMIN = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ROLE_ADMIN);
    public static final User USER_1 = new User(USER1_ID, "Herbert", "herbert@gmail.com", "herbert", Role.ROLE_USER);
    public static final User USER_2 = new User(USER2_ID, "Dominik", "dominik@gmail.com", "12345678", Role.ROLE_USER);

}
