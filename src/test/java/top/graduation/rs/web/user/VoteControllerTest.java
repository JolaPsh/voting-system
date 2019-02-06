package top.graduation.rs.web.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static top.graduation.rs.DishTestData.TODAY;
import static top.graduation.rs.RestaurantTestData.RESTAURANT_2;
import static top.graduation.rs.RestaurantTestData.RES_ID;
import static top.graduation.rs.TestUtil.contentJson;
import static top.graduation.rs.TestUtil.mockAuthorize;
import static top.graduation.rs.TestUtil.userAuth;
import static top.graduation.rs.UserTestData.USER_1;
import static top.graduation.rs.UserTestData.USER_2;
import static top.graduation.rs.VoteTestData.VOTE_1;
import static top.graduation.rs.VoteTestData.VOTE_HISTORY_USER_1;
import static top.graduation.rs.VoteTestData.assertMatch;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import top.graduation.rs.web.AbstractControllerTest;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */

class VoteControllerTest extends AbstractControllerTest {

	private static final String REST_URL = VoteController.REST_URL + "/";

	@Test
	void testGetUnAuthorized() throws Exception {
		mockMvc.perform(get(REST_URL + "history")
				.contentType(MediaType.APPLICATION_JSON))
		        .andDo(print())
				.andExpect(status().isUnauthorized());
	}

	@Test
	void vote() throws Exception {
		mockMvc.perform(post(REST_URL + (RES_ID + 1))
				.with(userAuth(USER_2))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andDo(print())
				.andExpect(contentJson(RESTAURANT_2));
	}

	@Test
	void getTodayUserVote() throws Exception {
		mockMvc.perform(get(REST_URL+"?date="+ TODAY)
				.with(userAuth(USER_1))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print());

		mockAuthorize(USER_1);
	    assertMatch(voteService.getTodayUserVote(1017, new Date()).orElse(null), VOTE_1);
	}

	@Test
	void getVotesBetween() throws Exception {
		mockMvc.perform(get(REST_URL + "history")
				.with(userAuth(USER_1))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print());

		mockAuthorize(USER_1);
		assertMatch(voteService.getVotesBetween(1017, null, null), VOTE_HISTORY_USER_1);
	}
}
