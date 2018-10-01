package top.graduation.rs.web.admin;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import top.graduation.rs.model.Restaurant;
import top.graduation.rs.service.RestaurantService;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */

@RestController
@RequestMapping(value = RestaurantAdminController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class RestaurantAdminController {

    private static final Logger log = LoggerFactory.getLogger(RestaurantAdminController.class);
    public static final String REST_URL = "/rest/admin/restaurants";

    @Autowired
    private RestaurantService service;

    @GetMapping
    public ResponseEntity<List<Restaurant>> getAll() {
        log.info("get all restaurants {}");
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> retrieve(@PathVariable("id") int id) throws NotFoundException {
        log.info("get restaurant with id {}", id);
        return service.retrieve(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) throws NotFoundException {
        log.info("delete restaurant with id {} ", id);
        service.delete(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Restaurant restaurant, UriComponentsBuilder ucBuilder) {
        log.info("create restaurant {}", restaurant);
        service.create(restaurant);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path(REST_URL + "/{id}").buildAndExpand(restaurant.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@RequestBody Restaurant newRestaurant, @PathVariable("id") int id) throws NotFoundException {
        log.info("update restaurant{} with id {}", newRestaurant, id);
        service.update(newRestaurant, id);
    }
}