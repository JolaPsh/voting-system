package top.graduation.rs;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import top.graduation.rs.web.admin.DishAdminController;
import top.graduation.rs.web.admin.RestaurantAdminController;
import top.graduation.rs.web.user.VoteController;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ControllerContextTest {

    @Autowired
    private RestaurantAdminController raController;

    @Autowired
    private DishAdminController daController;

    @Autowired
    private VoteController voteController;

    @Test
    void contextLoadsRestaurants() throws Exception {
        assertThat(raController).isNotNull();
    }

    @Test
    void contextLoadsDishes() throws Exception{
        assertThat(daController).isNotNull();
    }

    @Test
    void contextLoadsVotes() throws Exception {
        assertThat(voteController).isNotNull();
    }
}
