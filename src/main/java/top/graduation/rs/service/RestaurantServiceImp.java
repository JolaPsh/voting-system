package top.graduation.rs.service;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.graduation.rs.model.Restaurant;
import top.graduation.rs.repository.datajpa.RestaurantRepository;

import javax.cache.annotation.CacheResult;
import java.time.LocalDate;
import java.util.List;

import static top.graduation.rs.util.ValidationUtil.checkNotFoundWithId;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

@Service
public class RestaurantServiceImp implements RestaurantService {

    private static Logger log = LoggerFactory.getLogger(RestaurantServiceImp.class);

    @Autowired
    private RestaurantRepository repository;

    @Override
    @CacheResult(cacheName = "restaurants")
    public List<Restaurant> getAll() {
        log.info("get all restaurants {}");
        return repository.findAll();
    }

    @Override
    public Restaurant retrieve(int id) throws NotFoundException {
        log.info("get restaurant with id {}", id);
        return checkNotFoundWithId(repository.findById(id).orElse(null), id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        log.info("delete restaurant with id {}", id);
        checkNotFoundWithId(repository.delete(id), id);
    }

    @Override
    @CacheResult(cacheName = "restaurants")
    public Restaurant create(Restaurant newRestaurant) {
        log.info("create restaurant {}", newRestaurant);
        return repository.save(newRestaurant);
    }

    @Override
    public void update(Restaurant newRestaurant, int id) throws IllegalArgumentException, NotFoundException {
        log.info("update restaurant {} with id {}", newRestaurant, id);
        newRestaurant.setId(id);
        checkNotFoundWithId(repository.save(newRestaurant), id);
    }

    @Override
    @CacheResult(cacheName = "restaurants")
    public List<Restaurant> findByTitle(String title) {
        log.info("find restaurants by title ={}", title);
        return repository.findByTitle(title);
    }

    @Override
    @CacheResult(cacheName = "restaurants")
    public List<Restaurant> getRestaurantsWithDishes(LocalDate date) {
        log.info("get all restaurants with dishes {}");
        return repository.getRestaurantsWithDishes(date);
    }
}
