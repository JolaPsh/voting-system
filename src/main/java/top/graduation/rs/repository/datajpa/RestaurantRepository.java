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

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT r FROM Restaurant r WHERE r.title LIKE CONCAT('%', :title, '%')")
    List<Restaurant> findByTitle(@Param("title") String title);

    @Transactional(readOnly = true)
    @Query("SELECT r.id, r.location, r.title, d.name, d.price FROM Dish d JOIN d.restaurant r WHERE d.date=:date")
    List<Restaurant> getRestaurantsWithDishes(@Param("date") LocalDate date);
}
