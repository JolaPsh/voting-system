package top.graduation.rs.service;

import javassist.NotFoundException;
import top.graduation.rs.model.Restaurant;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

public interface RestaurantService {

    List<Restaurant> getAll(int userId);

    Optional<Restaurant> get(int id, int userId) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    Restaurant create(Restaurant restaurant);

    Restaurant update(Restaurant restaurant, int id) throws NotFoundException;
}
