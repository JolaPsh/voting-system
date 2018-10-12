package top.graduation.rs.service;

import javassist.NotFoundException;
import org.springframework.security.access.annotation.Secured;
import top.graduation.rs.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

public interface RestaurantService {
    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    List<Restaurant> getAll();

    @Secured({"ROLE_ADMIN"})
    Restaurant retrieve(int id) throws NotFoundException;

    @Secured({"ROLE_ADMIN"})
    void delete(int id) throws NotFoundException;

    @Secured({"ROLE_ADMIN"})
    Restaurant create(Restaurant restaurant);

    @Secured({"ROLE_ADMIN"})
    void update(Restaurant restaurant, int id) throws NotFoundException;

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    List<Restaurant> findByTitle(String title);

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    List<Restaurant> getRestaurantsWithDishes(LocalDate date);

}
