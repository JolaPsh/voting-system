package top.graduation.rs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.graduation.rs.model.Restaurant;
import top.graduation.rs.repository.RestaurantRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantRepository repo;

    @GetMapping("/restaurants")
    public List<Restaurant> getAll() {
        return repo.findAll();
    }

/*    @GetMapping("/restaurants/{id}")
    public Restaurant get(@PathVariable String id) {
        int resId = Integer.parseInt(id);
        return repo.getOne(resId);
    }*/

    @GetMapping("/restaurants/{id}")
    public Restaurant retrieveOne(@PathVariable int id) {
        Optional<Restaurant> restaurantOptional = repo.findById(id);
        if (!restaurantOptional.isPresent()) {
            System.out.print("Restaurant doesn't exists");
        }
        return restaurantOptional.get();
    }

    @DeleteMapping("/restaurants/{id}")
    public void delete(@PathVariable int id) {
        repo.deleteById(id);
    }

    @PutMapping("/restaurants/{id}")
    public ResponseEntity<Object> updateOne(@RequestBody Restaurant restaurant, @PathVariable int id) {
        Optional<Restaurant> restaurantOptional = repo.findById(id);
        return null;
    }
}
