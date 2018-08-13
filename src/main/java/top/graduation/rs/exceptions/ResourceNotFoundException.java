package top.graduation.rs.exceptions;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
