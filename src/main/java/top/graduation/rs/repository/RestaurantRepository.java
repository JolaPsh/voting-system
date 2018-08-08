package top.graduation.rs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.graduation.rs.model.Restaurant;

import java.util.List;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */
public interface RestaurantRepository extends JpaRepository {

    Restaurant get(int id);

    Restaurant save(Restaurant restaurant);

    boolean delete(int id);

    List<Restaurant> getAll();

    default Restaurant test() {
        throw new UnsupportedOperationException();
    }

}
