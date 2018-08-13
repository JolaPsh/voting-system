package top.graduation.rs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.graduation.rs.model.Restaurant;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

}
