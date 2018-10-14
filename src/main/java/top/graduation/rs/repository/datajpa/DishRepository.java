package top.graduation.rs.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import top.graduation.rs.model.Dish;
import top.graduation.rs.model.Restaurant;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

@Transactional(readOnly = true)
public interface DishRepository extends JpaRepository<Dish, Integer> {

    @Transactional
    @Override
    Dish save(Dish dish);

    @Transactional
    @Modifying
    @Query("DELETE FROM Dish d WHERE d.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT d FROM Dish d WHERE d.restaurant=:restaurant")
    Dish findByRestaurant(@Param("restaurant") Restaurant restaurant);

    @Query("SELECT d.date, d.name, d.price, r.title, u.email FROM Dish d, Vote v " +
            "JOIN v.user u JOIN d.restaurant r WHERE v.date=d.date AND d.id=:id")
    Object[] getDishHistory(@Param("id") int id);
}
