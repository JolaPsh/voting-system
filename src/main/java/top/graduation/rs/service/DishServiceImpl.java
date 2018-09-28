package top.graduation.rs.service;

import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import top.graduation.rs.model.Dish;
import top.graduation.rs.repository.datajpa.DishRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

@Service
public class DishServiceImpl implements DishService {

    private static Logger log = LoggerFactory.getLogger(RestaurantServiceImp.class);

    @Autowired
    private DishRepository repository;

    @Override
    public List<Dish> getAll() {
        log.info("get all dishes {}");
        return repository.findAll();
    }

    @Override
    @Secured("ROLE_ADMIN")
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
    public void update(Dish newDish, int id) throws NotFoundException {
        log.info("update dish {} with id {}", newDish, id);
        Optional<Dish> restaurantOptional = repository.findById(id);
        if (!restaurantOptional.isPresent()) {
            throw new NotFoundException("Restaurant not found");
        }
        newDish.setId(id);
        repository.save(newDish);
    }
}
