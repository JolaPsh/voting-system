package top.graduation.rs.util.exceptions;

import org.springframework.lang.NonNull;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */
public class IllegalRequestDataException extends RuntimeException {
    public IllegalRequestDataException(@NonNull String msg) {
        super(msg);
    }
}