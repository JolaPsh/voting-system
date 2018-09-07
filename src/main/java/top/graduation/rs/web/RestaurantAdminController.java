package top.graduation.rs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@RequestMapping(value = RestaurantAdminController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantAdminController {

    private static final Logger log = LoggerFactory.getLogger(RestaurantAdminController.class);
    static final String REST_URL = "rest/admin/restaurants";

    @Autowired
    private RestaurantRepository repo;

    @GetMapping
    public List<Restaurant> getAll() {
        log.info("get all restaurants");
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Restaurant retrieve(@PathVariable("id") int id) throws ResourceNotFoundException {
        log.info("get restaurant with id {}", id);
        Optional<Restaurant> restaurantOptional = repo.findById(id);
        if (!restaurantOptional.isPresent()) {
            throw new ResourceNotFoundException("Restaurant doesn't exists");
        }
        return restaurantOptional.get();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id) {
        log.info("delete restaurant with id {} ", id);
        repo.deleteById(id);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Restaurant update(@RequestBody Restaurant newRestaurant, @PathVariable("id") int id) {
        log.info("update restaurant with id {}", id);
        return repo.findById(id).map(restaurant -> {
            restaurant.setLocation(newRestaurant.getLocation());
            restaurant.setTitle(newRestaurant.getTitle());
            return repo.save(restaurant);
        }).
                orElseGet(() -> {
                    newRestaurant.setId(id);
                    return repo.save(newRestaurant);
                });
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Restaurant restaurant, UriComponentsBuilder ucBuilder) {
        log.info("create restaurant {}", restaurant);
        repo.save(restaurant);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path(REST_URL + "/{id}").buildAndExpand(restaurant.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
}
