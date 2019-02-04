package top.graduation.rs.web.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import top.graduation.rs.View;
import top.graduation.rs.model.Restaurant;
import top.graduation.rs.service.RestaurantService;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

@RestController
@RequestMapping(value = RootController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RootController {

    private static final Logger log = LoggerFactory.getLogger(RootController.class);
    public static final String REST_URL = "/rest/restaurants";

    @Autowired
    private RestaurantService service;

	@JsonView(View.SummaryWithDishes.class)
    @GetMapping("/dishes")
    public ResponseEntity<List<Restaurant>> getRestaurantsWithDishes() {
        log.info("get all restaurants with dishes : {} ", service.getRestaurantsWithDishes());
        List<Restaurant> allRestaurantsWithDishes = service.getRestaurantsWithDishes();
        return new ResponseEntity<>(allRestaurantsWithDishes, HttpStatus.OK);
    }

    @GetMapping("/searchByTitle")
    public ResponseEntity<List<Restaurant>> findByTitle(@RequestParam("title") String title) {
        log.info("find restaurants by title ={}", title);
        return new ResponseEntity<>(service.findByTitle(title), HttpStatus.OK);
    }
}
