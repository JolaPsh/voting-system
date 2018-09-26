package top.graduation.rs.service;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.graduation.rs.model.Dish;
import top.graduation.rs.repository.datajpa.DishRepository;
import top.graduation.rs.web.SecurityUtil;

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
        log.info("get all dishes {}");
        return repository.findAll().stream().filter(v -> SecurityUtil.authUserId() == userId)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Dish> get(int id) throws NotFoundException {
        log.info("get dish with id {}", id);
        return repository.findById(id);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        log.info("delete dish with id {}", id);
        repository.deleteById(id);
    }

    @Override
    public Dish create(Dish newDish) {
        log.info("create dish {}", newDish);
        return repository.save(newDish);
    }

    @Override
    public Dish update(Dish newDish, int id) throws NotFoundException {
        log.info("update dish {} with id {}", newDish, id);
        return repository.findById(newDish.getId()).map(v -> {
            newDish.setName(v.getName());
            newDish.setPrice(v.getPrice());
            newDish.setRestaurant(v.getRestaurant());
            newDish.setDate(LocalDate.now());
            return repository.save(newDish);
        }).
                orElseGet(() -> {
                    newDish.setId(id);
                    return repository.save(newDish);
                });
    }
}
