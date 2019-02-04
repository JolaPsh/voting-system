package top.graduation.rs.repository.datajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import top.graduation.rs.model.Restaurant;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */

@Transactional(readOnly = true)
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Query("SELECT r FROM Restaurant r ORDER BY r.title")
    List<Restaurant> getAll();

    @Transactional
    @Override
    Restaurant save(Restaurant restaurant);

    @Transactional
    @Modifying
    @Query("DELETE FROM Restaurant r WHERE r.id=:id")
    int delete(@Param("id") int id);

    @Query("SELECT r FROM Restaurant r WHERE r.title LIKE CONCAT('%', :title, '%')")
    List<Restaurant> findByTitle(@Param("title") String title);

    @Query("SELECT DISTINCT r FROM Restaurant r JOIN FETCH r.dishes ORDER BY r.title")
    List<Restaurant> getRestaurantsWithDishes();
}
