package top.graduation.rs.service;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.graduation.rs.AuthorizedUser;
import top.graduation.rs.model.Dish;
import top.graduation.rs.repository.datajpa.DishRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

@Service
public class DishServiceImpl implements DishService {

    private static Logger log = LoggerFactory.getLogger(RestaurantServiceImp.class);

    @Autowired
    private DishRepository repository;

    @Override
    public List<Dish> getAll(int userId) {
        return repository.findAll().stream().filter(v -> AuthorizedUser.id() == userId).collect(Collectors.toList());
    }

    @Override
    public Optional<Dish> get(int id) throws NotFoundException {
        return repository.findById(id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        repository.deleteById(id);
    }

    @Override
    public Dish create(Dish dish) {
        return repository.save(dish);
    }

    @Override
    public Dish update(Dish dish, int id) throws NotFoundException {
        return repository.findById(dish.getId()).map(v -> {
            dish.setName(v.getName());
            dish.setPrice(v.getPrice());
            dish.setRestaurant(v.getRestaurant());
            dish.setDate(LocalDate.now());
            return repository.save(dish);
        }).
                orElseGet(() -> {
                    dish.setId(id);
                    return repository.save(dish);
                });
    }
}
