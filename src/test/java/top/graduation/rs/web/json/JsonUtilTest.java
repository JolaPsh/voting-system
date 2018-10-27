package top.graduation.rs.web.json;

import org.junit.jupiter.api.Test;
import top.graduation.rs.model.Restaurant;

import java.util.List;

import static top.graduation.rs.RestaurantTestData.*;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */
public class JsonUtilTest {

    @Test
    void testReadWriteValue() throws Exception {
        String json = JsonUtil.writeValue(RESTAURANT_2);
        System.out.println(json);
        Restaurant restaurant = JsonUtil.readValue(json, Restaurant.class);
        assertMatch(restaurant, RESTAURANT_2);
    }

    @Test
    void testReadWriteValues() throws Exception {
        String json = JsonUtil.writeValue(RESTAURANTS);
        System.out.println(json);
        List<Restaurant> restaurants = JsonUtil.readValues(json, Restaurant.class);
        assertMatch(restaurants, RESTAURANTS);
    }
}
