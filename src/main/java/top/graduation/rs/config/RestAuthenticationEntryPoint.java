package top.graduation.rs.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

@Component
public class RestAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exc) throws IOException, ServletException {
        response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
        response.setContentType("application/json");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exc.getMessage());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        setRealmName("Voting system, Spring Boot Security Application, Realm");
    }
}
