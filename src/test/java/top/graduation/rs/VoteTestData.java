package top.graduation.rs;

import top.graduation.rs.model.Vote;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static top.graduation.rs.model.AbstractBaseEntity.START_SEQ;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */
public class VoteTestData {
    public static final int VOTE_ID = START_SEQ+25;

  //  public static final Vote VOTE_1 = new Vote(VOTE_ID, USER_1, RESTAURANT_2, Date.valueOf(LocalDate.now()));

  //  public static final List<Vote> VOTES_USER2 = Arrays.asList(VOTE_1);

    public static void assertMatch(Vote actual, Vote expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Vote> actual, Vote... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Vote> actual, Iterable<Vote> expected) {
        assertThat(actual).isEqualTo(expected);
    }
}
