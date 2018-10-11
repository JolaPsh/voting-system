package top.graduation.rs.web.admin;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import top.graduation.rs.model.Restaurant;
import top.graduation.rs.service.RestaurantService;
import top.graduation.rs.web.AbstractControllerTest;
import top.graduation.rs.web.json.JsonUtil;

import java.util.Comparator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static top.graduation.rs.RestaurantTestData.*;
import static top.graduation.rs.TestUtil.assertMatch;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

public class RestaurantAdminControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RestaurantAdminController.REST_URL + "/";

    @Autowired
    private RestaurantService service;

    @WithMockUser(username = "herbert", roles = "USER")
    @Test
    public void testGetUnAuth() throws Exception {
        mockMvc.perform(get(REST_URL + RES_ID + 4))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @WithMockUser(username = "admin", roles = "ADMIN")
    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        RESTAURANTS.sort(Comparator.comparing(Restaurant::getTitle));
        assertMatch(service.getAll(), RESTAURANTS);
    }

    @WithMockUser(username = "admin", roles = "ADMIN")
    @Test
    public void testRetrieve() throws Exception {
        mockMvc.perform(get(REST_URL + RES_ID + 3)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        assertMatch(service.retrieve(RES_ID + 3).get(), RESTAURANT4);
    }

    @WithMockUser(username = "admin", roles = "ADMIN")
    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + RES_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @WithMockUser(username = "admin", roles = "ADMIN")
    @Test
    public void testUpdate() throws Exception {
        Restaurant updated = getUpdated();
        mockMvc.perform(put(REST_URL + RES_ID + 6)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isNoContent());

        assertMatch(service.retrieve(RES_ID + 6).get(), updated);
    }

    @WithMockUser(username = "admin", roles = "ADMIN")
    @Test
    public void testCreate() throws Exception {
        Restaurant created = getCreated();
        mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(JsonUtil.writeValue(created)))
                .andExpect(status().isCreated());

        assertMatch(service.getAll(), created, RESTAURANT7, RESTAURANT5, RESTAURANT3, RESTAURANT1,
                RESTAURANT2, RESTAURANT6, RESTAURANT4);
    }
}
