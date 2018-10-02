package top.graduation.rs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import top.graduation.rs.util.ErrorInfo;
import top.graduation.rs.util.ValidationUtil;
import top.graduation.rs.util.exceptions.IllegalRequestDataException;
import top.graduation.rs.util.exceptions.NotFoundException;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Joanna Pakosh on Сент., 2018
 */

@RestControllerAdvice(annotations = RestController.class)
public class ExceptionInfoHandler  {

    private static Logger log = LoggerFactory.getLogger(ExceptionInfoHandler.class);

    @ResponseStatus(value = HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErrorInfo handleConflict(HttpServletRequest req, DataIntegrityViolationException exc) {
        String msg = "Only one vote per person per day is allowed. Try again after 11 AM.";
        return logAndGetErrorInfo(HttpStatus.CONFLICT, req,  msg, exc, true);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //500
    @ExceptionHandler(Exception.class)
    public ErrorInfo handleInternalServerError(HttpServletRequest req, NotFoundException exc) {
       String msg = "Server error.";
        return logAndGetErrorInfo(HttpStatus.INTERNAL_SERVER_ERROR, req, msg, exc, true);
    }

    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)  // 422
    @ExceptionHandler({IllegalRequestDataException.class, MethodArgumentTypeMismatchException.class, HttpMessageNotReadableException.class})
    public ErrorInfo handleIllegalRequestDataError(HttpServletRequest req, Exception exc) {
       String msg = "You have attempted to add invalid data. Try again.";
        return logAndGetErrorInfo(HttpStatus.UNPROCESSABLE_ENTITY, req, msg, exc, false);
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)  //403
    @ExceptionHandler(AccessDeniedException.class)
    public ErrorInfo handleAuthorizationException(HttpServletRequest req, AccessDeniedException exc) {
        String msg = "You don't have permission to access " + req.getRequestURI();
        return  logAndGetErrorInfo(HttpStatus.FORBIDDEN, req, msg, exc, true );
    }

    private static ErrorInfo logAndGetErrorInfo(HttpStatus status, HttpServletRequest req, String errorMsg, Exception exc, boolean logException) {
        Throwable rootCause = ValidationUtil.getRootCause(exc);
        if (logException) {
            log.error("Exception at request {}" + req.getRequestURL(), rootCause);
        } else {
            log.warn("Exception at request {}: {}", req.getRequestURL(), rootCause.toString());
        }
        return new ErrorInfo(status, req.getRequestURL().toString(), errorMsg);
    }
}
