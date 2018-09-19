package top.graduation.rs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */

@SpringBootApplication
/*@EnableJpaRepositories("top.graduation.rs.repository")*/
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }
}
