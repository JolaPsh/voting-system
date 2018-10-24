package top.graduation.rs.web.admin;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
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
import static top.graduation.rs.TestUtil.contentJson;
import static top.graduation.rs.TestUtil.readFromJson;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */

public class RestaurantAdminControllerTest extends AbstractControllerTest {

    private static final String REST_URL = RestaurantAdminController.REST_URL + "/";

    @Autowired
    private RestaurantService service;

    @WithMockUser(username = "herbert", roles = "USER")
    @Test
    public void testGetForbidden() throws Exception {
        mockMvc.perform(get(REST_URL + (RES_ID + 4)))
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
        mockMvc.perform(get(REST_URL + (RES_ID + 3)))
                .andExpect(status().isOk())
                .andDo(print())
                // https://jira.spring.io/browse/SPR-14472
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJson(RESTAURANT_4));

        assertMatch(service.retrieve(RES_ID + 3), RESTAURANT_4);
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
    public void testCreate() throws Exception {
        Restaurant created = getCreated();
        ResultActions action = mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(created)))
                .andExpect(status().isCreated());

        Restaurant returned = readFromJson(action, Restaurant.class);
        created.setId(returned.getId());

        assertMatch(returned, created);
    }

    @WithMockUser(username = "admin", roles = "ADMIN")
    @Test
    public void testUpdate() throws Exception {
        Restaurant updated = getUpdated();
        mockMvc.perform(put(REST_URL + RES_ID + 6)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isOk());

        assertMatch(service.retrieve(RES_ID + 6), updated);
    }
}
