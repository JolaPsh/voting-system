package top.graduation.rs.service;

import javassist.NotFoundException;
import org.springframework.security.access.annotation.Secured;
import top.graduation.rs.model.Dish;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */
public interface DishService {
    @Secured({"ROLE_ADMIN"})
    List<Dish> getAll();

    @Secured({"ROLE_ADMIN"})
    Optional<Dish> retrieve(int id) throws NotFoundException;

    @Secured({"ROLE_ADMIN"})
    void delete(int id) throws NotFoundException;

    @Secured({"ROLE_ADMIN"})
    Dish create(Dish dish);

    @Secured({"ROLE_ADMIN"})
    void update(Dish dish, int id) throws NotFoundException;
}
