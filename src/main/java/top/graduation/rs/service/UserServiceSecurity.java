package top.graduation.rs.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.graduation.rs.AuthorizedUser;
import top.graduation.rs.model.User;
import top.graduation.rs.repository.datajpa.UserRepository;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

@Service
public class UserServiceSecurity implements UserDetailsService {

    private final Logger log = LoggerFactory.getLogger(UserServiceSecurity.class);

    @Autowired
    private UserRepository repository;

    /**
     * Returns user with specified email;
     * @param email of user that should be returned
     * @return user with specified email;
     */
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email.trim().toLowerCase());
        log.debug("Authenticating {}", email);
        if (user == null) {
            throw new UsernameNotFoundException("User with email" + email + " not found");
        }
        return new AuthorizedUser(user);
    }
}

