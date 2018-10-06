package top.graduation.rs.web.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.graduation.rs.model.Restaurant;
import top.graduation.rs.service.RestaurantService;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

@RestController
@RequestMapping(value = RootController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RootController {

    private static final Logger log = LoggerFactory.getLogger(RootController.class);
    public static final String REST_URL = "/rest/profile/restaurants";

    @Autowired
    private RestaurantService service;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAll() {
        log.info("get all restaurants {}");
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/dishes")
    public ResponseEntity<List<Restaurant>> getRestaurantsWithDishes(@RequestParam(value = "date", required = false)
                                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        log.info("get all restaurants with dishes, localDate ={}", date);
        List<Restaurant> allRestaurantsWithDishes = service.getRestaurantsWithDishes(date);
        return new ResponseEntity<>(allRestaurantsWithDishes, HttpStatus.OK);
    }

    @GetMapping("/searchByTitle")
    public ResponseEntity<List<Restaurant>> findByTitle(@RequestParam("title") String title) {
        log.info("find restaurants by title ={}", title);
        return new ResponseEntity<>(service.findByTitle(title), HttpStatus.OK);
    }
}
