package top.graduation.rs.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import top.graduation.rs.model.Restaurant;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */

@Transactional(readOnly = true)
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Override
    @Query("SELECT r FROM Restaurant r ORDER BY r.title")
    List<Restaurant> findAll();

    @Transactional
    @Override
    Restaurant save(Restaurant restaurant);

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT r FROM Restaurant r WHERE r.title LIKE CONCAT('%', :title, '%')")
    List<Restaurant> findByTitle(@Param("title") String title);

    @Query("SELECT r.id, r.title, r.location, d.name, d.price FROM Dish d JOIN d.restaurant r WHERE d.date=:date ORDER BY r.title")
    List<Restaurant> getRestaurantsWithDishes(@Param("date") LocalDate date);
}
