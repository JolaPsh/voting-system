package top.graduation.rs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */

@SpringBootApplication
public class SpringBootApp {

    public static void main(String[] args) {
      //SpringApplication.run(SpringBootApp.class, args);
      //Test
        ApplicationContext context = SpringApplication.run(SpringBootApp.class);
        DataSource dataSource = context.getBean(javax.sql.DataSource.class);
        System.out.println("DATASOURCE = " + dataSource);
    }
}
