package top.graduation.rs.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import top.graduation.rs.model.Dish;
import top.graduation.rs.model.Restaurant;

import java.util.List;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

    @Override
        //  @Secured("ROLE_ADMIN")
    Dish save(Dish dish);

    @Query("SELECT d FROM Dish d WHERE d.restaurant=:restaurant")
    Dish findByRestaurant(@Param("restaurant") Restaurant restaurant);

    @Query("SELECT d.id, d.date, d.name, d.restaurant.title, v.id FROM Dish d " +
            "LEFT JOIN Vote v ON d.restaurant.id=:id")
    List<Dish> getDishHistory(int id);
}
