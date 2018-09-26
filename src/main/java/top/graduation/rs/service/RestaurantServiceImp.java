package top.graduation.rs.service;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
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
        return repository.getAll(userId);
    }

    @Override
    public Optional<Restaurant> get(int id, int userId) throws NotFoundException {
        Optional<Restaurant> restaurantOptional = repository.findById(id);
        if (!restaurantOptional.isPresent()) {
            throw new NotFoundException("Restaurant not found");
        }
        return restaurantOptional;
    }

    @Override
    public void delete(int id) throws NotFoundException {
        repository.deleteById(id);
    }

    @Override
    public Restaurant create(Restaurant restaurant) {
        return repository.save(restaurant);
    }

    @Override
    public Restaurant update(Restaurant restaurant, int id) throws NotFoundException {
        return repository.findById(restaurant.getId()).map(v -> {
            restaurant.setTitle(v.getTitle());
            restaurant.setLocation(v.getLocation());
            return repository.save(restaurant);
        }).
                orElseGet(() -> {
                    restaurant.setId(id);
                    return repository.save(restaurant);
                });
    }
}
