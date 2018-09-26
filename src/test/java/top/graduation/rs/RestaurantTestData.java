package top.graduation.rs;

import top.graduation.rs.model.Restaurant;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static top.graduation.rs.model.AbstractBaseEntity.START_SEQ;

/**
 * Created by Joanna Pakosh on Сент., 2018
 */
public class RestaurantTestData {

    public static final int RES_ID = START_SEQ;

    public static final Restaurant RESTAURANT1 = new Restaurant (RES_ID, "Local", "33 Dark Spurt, Lviv");
    public static final Restaurant RESTAURANT2 = new Restaurant (RES_ID + 1, "Panorama", "44 Zankoveckoj street, Lviv");
    public static final Restaurant RESTAURANT3 = new Restaurant (RES_ID + 2, "Kruivka", "11 Mykolaja street, Ternopil");
    public static final Restaurant RESTAURANT4 = new Restaurant (RES_ID + 3, "Varenuku", "101 Filbert street, Lviv");
    public static final Restaurant RESTAURANT5 = new Restaurant (RES_ID + 4, "Frontos", "2 Chapel street, Lviv");
    public static final Restaurant RESTAURANT6 = new Restaurant (RES_ID + 5, "Shekspire", "17 Kosmonavtov street, Lviv");
    public static final Restaurant RESTAURANT7 = new Restaurant (RES_ID + 6, "Fransua", "44 Lenina street, Lviv");

    public static final List<Restaurant> RESTAURANTS = Arrays.asList(RESTAURANT1, RESTAURANT2, RESTAURANT3,
            RESTAURANT4, RESTAURANT5, RESTAURANT6, RESTAURANT7);

    public static void assertMatch(Restaurant actual, Restaurant expected) {
        assertThat(actual).isEqualToIgnoringGivenFields(expected);
    }

}
