package top.graduation.rs.util;

import org.springframework.http.HttpStatus;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */
public class ErrorInfo {
    private HttpStatus status;
    private String url;
    private String errorMessage;
    private String[] details;

    public ErrorInfo(HttpStatus status, String url, String errorMessage) {
        this.status = status;
        this.url = url;
        this.errorMessage = errorMessage;
    }

    public ErrorInfo(CharSequence url, String errorMessage, String... details) {
        this.url = url.toString();
        this.errorMessage = errorMessage;
        this.details = details;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getUrl() {
        return url;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String[] getDetails() {
        return details;
    }
}
