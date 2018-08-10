package top.graduation.rs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.graduation.rs.model.Restaurant;
import top.graduation.rs.repository.RestaurantRepository;

import java.util.List;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository repository;

    @RequestMapping("/hello")
    public String test() {
        return "HI!";
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getAll() {
        return repository.findAll();
    }
}
