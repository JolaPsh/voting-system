package top.graduation.rs.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import top.graduation.rs.model.Dish;
import top.graduation.rs.util.exceptions.NotFoundException;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */
public interface DishService {
    @Secured({"ROLE_ADMIN"})
    List<Dish> getAll();

    @Secured({"ROLE_ADMIN"})
    Dish retrieve(int id) throws NotFoundException;

    @Secured({"ROLE_ADMIN"})
    void delete(int id) throws NotFoundException;

    @Secured({"ROLE_ADMIN"})
    Dish create(Dish dish);

    @Secured({"ROLE_ADMIN"})
    void update(Dish dish, int id) throws NotFoundException;
}
