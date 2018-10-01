package top.graduation.rs.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import top.graduation.rs.model.Dish;
import top.graduation.rs.model.Restaurant;

import java.util.List;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

public interface DishRepository extends JpaRepository<Dish, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Dish d WHERE d.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT d FROM Dish d WHERE d.restaurant=:restaurant")
    Dish findByRestaurant(@Param("restaurant") Restaurant restaurant);

    @Query("SELECT d.id, d.date, d.name, d.restaurant.title, v.id FROM Dish d " +
            "LEFT JOIN Vote v ON d.restaurant.id=:id")
    List<Dish> getDishHistory(@Param("id") int id);
}
