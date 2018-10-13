package top.graduation.rs;

import top.graduation.rs.model.Restaurant;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static top.graduation.rs.model.AbstractBaseEntity.START_SEQ;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */
public class RestaurantTestData {

    public static final int RES_ID = START_SEQ;

    public static final Restaurant RESTAURANT_1 = new Restaurant(RES_ID, "Local", "33 Dark Spurt, Lviv");
    public static final Restaurant RESTAURANT_2 = new Restaurant(RES_ID + 1, "Panorama", "44 Zankoveckoj street, Lviv");
    public static final Restaurant RESTAURANT_3 = new Restaurant(RES_ID + 2, "Kruivka", "11 Mykolaja street, Ternopil");
    public static final Restaurant RESTAURANT_4 = new Restaurant(RES_ID + 3, "Varenuku", "101 Filbert street, Lviv");
    public static final Restaurant RESTAURANT_5 = new Restaurant(RES_ID + 4, "Frontos", "2 Chapel street, Lviv");
    public static final Restaurant RESTAURANT_6 = new Restaurant(RES_ID + 5, "Shekspire", "17 Kosmonavtov street, Lviv");
    public static final Restaurant RESTAURANT_7 = new Restaurant(RES_ID + 6, "Fransua", "44 Lenina street, Lviv");

    public static final List<Restaurant> RESTAURANTS = Arrays.asList(RESTAURANT_1, RESTAURANT_2, RESTAURANT_3,
            RESTAURANT_4, RESTAURANT_5, RESTAURANT_6, RESTAURANT_7);

    public static Restaurant getUpdated() {
        return new Restaurant(RES_ID + 6, RESTAURANT_7.getTitle(), "33 Nekrasova Street, Lviv");
    }

    public static Restaurant getCreated() {
        return new Restaurant(null, "Alibaba", "67 Vyhovskoho street, Lviv");
    }

    public static void assertMatch(Restaurant actual, Restaurant expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Restaurant> actual, Restaurant... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Restaurant> actual, Iterable<Restaurant> expected) {
        assertThat(actual).isEqualTo(expected);
    }
}
