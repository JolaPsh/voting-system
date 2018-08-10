package top.graduation.rs.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */


@RestController
public class RestaurantController {
    @RequestMapping("/hello")
    public String test() {
        return "HI!";
    }
}
