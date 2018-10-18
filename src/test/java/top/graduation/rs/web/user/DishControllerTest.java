package top.graduation.rs.web.user;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import top.graduation.rs.service.DishService;
import top.graduation.rs.web.AbstractControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static top.graduation.rs.DishTestData.DISH_HISTORY_13;
import static top.graduation.rs.DishTestData.DISH_ID;
import static top.graduation.rs.TestUtil.assertMatch;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */

public class DishControllerTest extends AbstractControllerTest {

    private static final String REST_URL = DishController.REST_URL + "/";

    @Autowired
    private DishService service;

    @WithMockUser(username = "Herbert", roles = "USER")
    @Test
    public void getDishHistory() throws Exception{
        mockMvc.perform(get(REST_URL+(DISH_ID +13)+"/history")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());

        assertMatch(service.getDishHistory(1023), DISH_HISTORY_13);
    }
}
