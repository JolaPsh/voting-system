package top.graduation.rs.web.admin;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

import top.graduation.rs.View;
import top.graduation.rs.model.Restaurant;
import top.graduation.rs.service.RestaurantService;
import top.graduation.rs.util.exceptions.NotFoundException;

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

	@JsonView(View.Summary.class)
    @GetMapping
    public ResponseEntity<List<Restaurant>> getAll(){
        log.info("get all restaurants {}");
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

	@JsonView(View.Summary.class)
    @GetMapping("/{id}")
    public Restaurant retrieve(@PathVariable("id") int id) throws NotFoundException {
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
    public ResponseEntity<Restaurant> create(@RequestBody Restaurant restaurant, UriComponentsBuilder ucBuilder) {
        log.info("create restaurant {}", restaurant);
        Restaurant created = service.create(restaurant);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path(REST_URL + "/{id}").buildAndExpand(restaurant.getId()).toUri());
        return new ResponseEntity<>(created, headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Restaurant newRestaurant, @PathVariable("id") int id) throws NotFoundException {
        log.info("update restaurant{} with id {}", newRestaurant, id);
        service.update(newRestaurant, id);
    }
}