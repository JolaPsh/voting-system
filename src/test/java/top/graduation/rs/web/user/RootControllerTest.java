package top.graduation.rs.web.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static top.graduation.rs.RestaurantTestData.RESTAURANTS;
import static top.graduation.rs.RestaurantTestData.RESTAURANT_4;
import static top.graduation.rs.RestaurantTestData.assertMatch;
import static top.graduation.rs.TestUtil.contentJsonArray;
import static top.graduation.rs.TestUtil.mockAuthorize;
import static top.graduation.rs.TestUtil.userAuth;
import static top.graduation.rs.UserTestData.USER_1;
import static top.graduation.rs.UserTestData.USER_2;

import java.util.Comparator;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import top.graduation.rs.model.Restaurant;
import top.graduation.rs.web.AbstractControllerTest;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */

class RootControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RootController.REST_URL + "/";

    @Test
    void getRestaurantsWithDishes() throws Exception {
        mockMvc.perform(get(REST_URL + "dishes")
                .with(userAuth(USER_1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        mockAuthorize(USER_1);
        RESTAURANTS.sort(Comparator.comparing(Restaurant::getTitle));
        assertMatch(restaurantService.getRestaurantsWithDishes(), RESTAURANTS);
    }

    @Test
    void findByTitle() throws Exception {
        mockMvc.perform(get(REST_URL + "searchByTitle?title=ku")
                .with(userAuth(USER_2))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(contentJsonArray(RESTAURANT_4));

        mockAuthorize(USER_2);
        assertMatch(restaurantService.findByTitle("ku"), RESTAURANT_4);
    }
}
