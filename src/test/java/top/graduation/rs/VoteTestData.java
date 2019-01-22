package top.graduation.rs;

import top.graduation.rs.model.Vote;
import top.graduation.rs.to.VoteHistory;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static top.graduation.rs.RestaurantTestData.RESTAURANT_1;
import static top.graduation.rs.UserTestData.USER_1;
import static top.graduation.rs.model.AbstractBaseEntity.START_SEQ;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */
public class VoteTestData {

    public static final int VOTE_ID = START_SEQ+19;
    public static final Vote VOTE_1 = new Vote(VOTE_ID, USER_1, RESTAURANT_1, new Date());
    public static final VoteHistory VOTE_1_USER_1 = new VoteHistory(VOTE_1.getId(),
            getDateWithoutTime(new Date()),
            VOTE_1.getRestaurant().getTitle());

    public static final List<VoteHistory> VOTE_HISTORY_USER_1 = Arrays.asList(VOTE_1_USER_1);

    public static void assertMatch(VoteHistory actual, VoteHistory expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<VoteHistory> actual, VoteHistory... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<VoteHistory> actual, Iterable<VoteHistory> expected) {
        assertThat(actual).isEqualTo(expected);
    }

    private static Date getDateWithoutTime(final Date dateOnly) {
        final Calendar cal = Calendar.getInstance();
        cal.clear(Calendar.HOUR_OF_DAY);
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);
        cal.setTime(dateOnly);
        return dateOnly;
    }
}