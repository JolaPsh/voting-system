package top.graduation.rs.service;

import javassist.NotFoundException;
import top.graduation.rs.model.Dish;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */
public interface DishService {

    List<Dish> getAll(int userId);

    Optional<Dish> get(int id) throws NotFoundException;

    void delete(int id) throws NotFoundException;

    Dish create(Dish dish);

    void update(Dish dish, int id) throws NotFoundException;
}
