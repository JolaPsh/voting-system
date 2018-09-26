package top.graduation.rs.service;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.graduation.rs.model.Restaurant;
import top.graduation.rs.repository.datajpa.RestaurantRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

@Service
public class RestaurantServiceImp implements RestaurantService {

    private static Logger log = LoggerFactory.getLogger(RestaurantServiceImp.class);

    @Autowired
    private RestaurantRepository repository;

    @Override
    public List<Restaurant> getAll(int userId) {
        log.info("get all restaurants {}");
        return repository.getAll(userId);
    }

    @Override
    public Optional<Restaurant> get(int id, int userId) throws NotFoundException {
        log.info("get restaurant with id {}", id);
        Optional<Restaurant> restaurantOptional = repository.findById(id);
        if (!restaurantOptional.isPresent()) {
            throw new NotFoundException("Restaurant not found");
        }
        return restaurantOptional;
    }

    @Override
    public void delete(int id) throws NotFoundException {
        log.info("delete restaurant with id {}", id);
        repository.deleteById(id);
    }

    @Override
    public Restaurant create(Restaurant newRestaurant) {
        log.info("create restaurant {}", newRestaurant);
        return repository.save(newRestaurant);
    }

    @Override
    public Restaurant update(Restaurant newRestaurant, int id) throws NotFoundException {
        log.info("update restaurant {} with id {}", newRestaurant, id);
        return repository.findById(newRestaurant.getId()).map(v -> {
            newRestaurant.setTitle(v.getTitle());
            newRestaurant.setLocation(v.getLocation());
            return repository.save(newRestaurant);
        }).
                orElseGet(() -> {
                    newRestaurant.setId(id);
                    return repository.save(newRestaurant);
                });
    }
}
