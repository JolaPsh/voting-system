package top.graduation.rs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import top.graduation.rs.exceptions.ResourceNotFoundException;
import top.graduation.rs.model.Restaurant;
import top.graduation.rs.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */

@RestController
public class RestaurantController {

    private static final Logger log = LoggerFactory.getLogger(RestaurantController.class);

    @Autowired
    private RestaurantRepository repo;

    @GetMapping("/restaurants")
    public List<Restaurant> getAll() {
        log.info("get all restaurants");
        return repo.findAll();
    }

    @GetMapping("/restaurants/{id}")
    public Restaurant retrieveOne(@PathVariable int id) throws ResourceNotFoundException {
        log.info("get restaurant with id {}", id);
        Optional<Restaurant> restaurantOptional = repo.findById(id);
        if (!restaurantOptional.isPresent()) {
            throw new ResourceNotFoundException("Restaurant doesn't exists");
        }
        return restaurantOptional.get();
    }

    @DeleteMapping("/restaurants/{id}")
    public void delete(@PathVariable int id) {
        log.info("delete restaurant with id {} ", id);
        repo.deleteById(id);
    }

    @PutMapping("/restaurants/{id}")
    public ResponseEntity<?> updateOne(@RequestBody Restaurant restaurant, @PathVariable int id) {
        log.info("update restaurant with id {}", id);
        Optional<Restaurant> restaurantOptional = repo.findById(id);
        if (!restaurantOptional.isPresent()) {
            throw new ResourceNotFoundException("Not Found");
        }

        repo.save(restaurant);
        return new ResponseEntity<Restaurant>(restaurant, HttpStatus.OK);
    }

    @PostMapping("/restaurants")
    public ResponseEntity<?> createOne(@RequestBody Restaurant restaurant, UriComponentsBuilder ucBuilder) {
        log.info("create restaurant {}", restaurant);
        repo.save(restaurant);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/restaurants/{id}").buildAndExpand(restaurant.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
}
