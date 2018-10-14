package top.graduation.rs.web.admin;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.ResultActions;
import top.graduation.rs.model.Dish;
import top.graduation.rs.service.DishService;
import top.graduation.rs.web.AbstractControllerTest;
import top.graduation.rs.web.json.JsonUtil;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static top.graduation.rs.DishTestData.*;
import static top.graduation.rs.TestUtil.contentJson;
import static top.graduation.rs.TestUtil.readFromJson;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */
public class DishAdminControllerTest extends AbstractControllerTest {

    private static final String REST_URL = DishAdminController.REST_URL + "/";

    @Autowired
    private DishService service;

    @WithMockUser(username = "herbert", roles = "USER")
    @Test
    public void testGetUnAuth() throws Exception {
        mockMvc.perform(get(REST_URL + DISH_ID + 4))
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

        assertMatch(service.getAll(), DISHES);
    }

    @WithMockUser(username = "admin", roles = "ADMIN")
    @Test
    public void testRetrieve() throws Exception {
        mockMvc.perform(get(REST_URL + (DISH_ID + 5)))
                .andExpect(status().isOk())
                .andDo(print())
                // https://jira.spring.io/browse/SPR-14472
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(contentJson(DISH_6));

        assertMatch(service.retrieve(DISH_ID + 5), DISH_6);
    }

    @WithMockUser(username = "admin", roles = "ADMIN")
    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete(REST_URL + DISH_ID)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent())
                .andDo(print());
    }

    @WithMockUser(username = "admin", roles = "ADMIN")
    @Test
    public void testCreate() throws Exception {
        Dish created = getCreated();
        ResultActions action = mockMvc.perform(post(REST_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(created)))
                .andExpect(status().isCreated());

        Dish returned = readFromJson(action, Dish.class);
        created.setId(returned.getId());

        assertMatch(returned, created);
        assertMatch(service.getAll(), DISH_1, DISH_2, DISH_3, DISH_4, DISH_5, DISH_6, DISH_7,
                DISH_8, DISH_9, DISH_10, DISH_11, DISH_12, DISH_13, DISH_14, DISH_15, created);
    }

    @WithMockUser(username = "admin", roles = "ADMIN")
    @Test
    public void testUpdate() throws Exception  {
        Dish updated = getUpdated();
        mockMvc.perform(put(REST_URL + DISH_ID + 4)
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.writeValue(updated)))
                .andExpect(status().isOk());

        assertMatch(service.retrieve(DISH_ID + 4), updated);
    }
}
