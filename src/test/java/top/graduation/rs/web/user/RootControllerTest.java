package top.graduation.rs.web.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import top.graduation.rs.model.Restaurant;
import top.graduation.rs.service.RestaurantService;
import top.graduation.rs.web.AbstractControllerTest;

import java.time.LocalDate;
import java.util.Comparator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static top.graduation.rs.RestaurantTestData.*;
import static top.graduation.rs.TestUtil.*;
import static top.graduation.rs.UserTestData.USER_1;
import static top.graduation.rs.UserTestData.USER_2;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */

class RootControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RootController.REST_URL + "/";

    @Autowired
    private RestaurantService service;

    @Test
    void getRestaurantsWithDishes() throws Exception {
        mockMvc.perform(get(REST_URL + "dishes")
                .with(userAuth(USER_1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        mockAuthorize(USER_1);
        RESTAURANTS.sort(Comparator.comparing(Restaurant::getTitle));
        assertMatch(service.getRestaurantsWithDishes(LocalDate.now()), RESTAURANTS);
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
        assertMatch(service.findByTitle("ku"), RESTAURANT_4);
    }
}
