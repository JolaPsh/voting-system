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
import top.graduation.rs.model.Dish;
import top.graduation.rs.service.DishService;

import java.util.List;

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
        return service.get(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id) throws NotFoundException {
        log.info("delete dish with id {} ", id);
        service.delete(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody Dish newDish, UriComponentsBuilder ucBuilder){
        log.info("create dish {}", newDish);
        service.create(newDish);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path(REST_URL + "/{id}").buildAndExpand(newDish.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update (@RequestBody Dish newDish, @PathVariable("id") int id) throws NotFoundException {
        log.info("update dish {} with id {}", newDish, id);
        service.update(newDish, id);
    }
}

