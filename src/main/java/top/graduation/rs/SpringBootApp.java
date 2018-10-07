package top.graduation.rs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */

@SpringBootApplication
@EnableCaching
public class SpringBootApp {

    public static void main(String[] args) {
      SpringApplication.run(SpringBootApp.class, args);
    }
}
