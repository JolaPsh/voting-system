package top.graduation.rs.web.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import top.graduation.rs.model.Restaurant;
import top.graduation.rs.service.RestaurantService;
import top.graduation.rs.web.AbstractControllerTest;
import top.graduation.rs.web.json.JsonUtil;

import java.util.Comparator;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static top.graduation.rs.RestaurantTestData.*;
import static top.graduation.rs.TestUtil.*;
import static top.graduation.rs.UserTestData.ADMIN;
import static top.graduation.rs.UserTestData.USER_2;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

class RestaurantAdminControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RestaurantAdminController.REST_URL + "/";

    @Autowired
    private RestaurantService service;

    @Test
    void testGetForbidden() throws Exception {
        mockMvc.perform(get(REST_URL + (RES_ID + 4))
                .with(userAuth(USER_2)))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    @Test
    void testGetAll() throws Exception {
        mockMvc.perform(get(REST_URL)
                .with(userAuth(ADMIN))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        mockAuthorize(ADMIN);
        RESTAURANTS.sort(Comparator.comparing(Restaurant::getTitle));
        assertMatch(service.getAll(), RESTAURANTS);
    }

    @Test
    void testRetrieve() throws Exception {
        mockMvc.perform(get(REST_URL + (RES_ID + 3))
                .with(userAuth(ADMIN)))
                .andExpect(status().isOk())
                .andDo(print())
                // https://jira.spring.io/browse/SPR-14472
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJson(RESTAURANT_4));

        mockAuthorize(ADMIN);
        assertMatch(service.retrieve(RES_ID + 3), RESTAURANT_4);
    }

    @Test
    void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + RES_ID)
                .with(userAuth(ADMIN))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @Test
     void testCreate() throws Exception {
        Restaurant created = getCreated();
        ResultActions action = mockMvc.perform(post(REST_URL)
                .with(userAuth(ADMIN))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(created)))
                .andExpect(status().isCreated());

        Restaurant returned = readFromJson(action, Restaurant.class);
        created.setId(returned.getId());

        assertMatch(returned, created);
        mockAuthorize(ADMIN);
        assertMatch(service.getAll(), created, RESTAURANT_7, RESTAURANT_5, RESTAURANT_3, RESTAURANT_1, RESTAURANT_2,
                RESTAURANT_6, RESTAURANT_4);
    }

    @Test
    void testUpdate() throws Exception {
        Restaurant updated = getUpdated();
        mockMvc.perform(put(REST_URL + RES_ID + 6)
                .with(userAuth(ADMIN))
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isOk());

        mockAuthorize(ADMIN);
        assertMatch(service.retrieve(RES_ID + 6), updated);
    }
}
