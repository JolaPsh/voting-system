package top.graduation.rs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.graduation.rs.web.admin.DishAdminController;
import top.graduation.rs.web.admin.RestaurantAdminController;
import top.graduation.rs.web.user.VoteController;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerContextTest {

    @Autowired
    private RestaurantAdminController raController;

    @Autowired
    private DishAdminController daController;

    @Autowired
    private VoteController voteController;

    @Test
    public void contextLoadsRestaurants() throws Exception {
        assertThat(raController).isNotNull();
    }

    @Test
    public void contextLoadsDishes() throws Exception{
        assertThat(daController).isNotNull();
    }

    @Test
    public void contextLoadsVotes() throws Exception {
        assertThat(voteController).isNotNull();
    }
}
