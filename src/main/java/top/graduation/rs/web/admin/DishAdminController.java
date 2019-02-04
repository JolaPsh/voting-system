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

import top.graduation.rs.model.Dish;
import top.graduation.rs.service.DishService;
import top.graduation.rs.util.exceptions.NotFoundException;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */
@RestController
@RequestMapping(value = DishAdminController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class DishAdminController {

    private static final Logger log = LoggerFactory.getLogger(DishAdminController.class);
    public static final String REST_URL = "/rest/admin/dishes";

    @Autowired
    private DishService service;

    @GetMapping
    public ResponseEntity<List<Dish>> getAll() {
        log.info("get all dishes {}");
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Dish retrieve(@PathVariable("id") int id) throws NotFoundException {
        log.info("get dish with id {}", id);
        return service.retrieve(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) throws NotFoundException {
        log.info("delete dish with id {} ", id);
        service.delete(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> create(@RequestBody Dish dish, UriComponentsBuilder ucBuilder) {
        log.info("create dish {}", dish);
        Dish created = service.create(dish);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path(REST_URL + "/{id}").buildAndExpand(dish.getId()).toUri());
        return new ResponseEntity<>(created, headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update (@RequestBody Dish newDish, @PathVariable("id") int id) throws NotFoundException {
        log.info("update dish {} with id {}", newDish, id);
        service.update(newDish, id);
    }
}

