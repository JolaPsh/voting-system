package top.graduation.rs.web.json;

import org.junit.Test;
import top.graduation.rs.model.Restaurant;

import java.util.List;

import static top.graduation.rs.RestaurantTestData.*;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */
public class JsonUtilTest {

    @Test
    public void testReadWriteValue() throws Exception {
        String json = JsonUtil.writeValue(RESTAURANT2);
        System.out.println(json);
        Restaurant restaurant = JsonUtil.readValue(json, Restaurant.class);
        assertMatch(restaurant, RESTAURANT2);
    }

    @Test
    public void testReadWriteValues() throws Exception {
        String json = JsonUtil.writeValue(RESTAURANTS);
        System.out.println(json);
        List<Restaurant> restaurants = JsonUtil.readValues(json, Restaurant.class);
        assertMatch(restaurants, RESTAURANTS);
    }
}
