package top.graduation.rs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import top.graduation.rs.model.Restaurant;

import java.util.List;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

}
