package top.graduation.rs.web.user;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import top.graduation.rs.model.Restaurant;
import top.graduation.rs.service.RestaurantService;
import top.graduation.rs.web.AbstractControllerTest;

import java.util.Comparator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static top.graduation.rs.RestaurantTestData.*;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */
public class RootControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RootController.REST_URL + "/";

    @Autowired
    private RestaurantService service;

    @WithMockUser(username = "herbert", roles = "USER")
    @Test
    public void getAll() throws Exception{
        mockMvc.perform(get(REST_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        RESTAURANTS.sort(Comparator.comparing(Restaurant::getTitle));
        assertMatch(service.getAll(), RESTAURANTS);
    }

    @WithMockUser(username = "herbert", roles = "USER")
    @Test
    public void getRestaurantsWithDishes() throws Exception{
        mockMvc.perform(get(REST_URL+"dishes")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
        }

    @WithMockUser(username = "herbert", roles = "USER")
    @Test
    public void findByTitle() throws Exception{
        mockMvc.perform(get(REST_URL+"searchByTitle?title=ku")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        assertMatch(service.findByTitle("ku"), RESTAURANT4);
    }
}
