package top.graduation.rs;

import top.graduation.rs.model.Dish;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static top.graduation.rs.RestaurantTestData.*;
import static top.graduation.rs.model.AbstractBaseEntity.START_SEQ;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */

public class DishTestData {

    public static final int DISH_ID = START_SEQ + 10;
    public static final LocalDate today = LocalDate.now();

    public static final Dish DISH_1 = new Dish(DISH_ID, today, "Calamari", 33, RESTAURANT1);
    public static final Dish DISH_2 = new Dish(DISH_ID + 1, today, "Meat balls + Deruny", 112, RESTAURANT5);
    public static final Dish DISH_3 = new Dish(DISH_ID + 2, today, "Cabbage rolls", 52, RESTAURANT3);
    public static final Dish DISH_4 = new Dish(DISH_ID + 3, today, "Black tea", 10, RESTAURANT3);
    public static final Dish DISH_5 = new Dish(DISH_ID + 4, today, "Grape juice", 11, RESTAURANT5);
    public static final Dish DISH_6 = new Dish(DISH_ID + 5, today, "Cocoa", 15, RESTAURANT1);
    public static final Dish DISH_7 = new Dish(DISH_ID + 6, today, "Omelette", 27, RESTAURANT3);
    public static final Dish DISH_8 = new Dish(DISH_ID + 7, today, "Casserole", 72, RESTAURANT7);
    public static final Dish DISH_9 = new Dish(DISH_ID + 8, today, "Coffe", 12, RESTAURANT1);
    public static final Dish DISH_10 = new Dish(DISH_ID + 9, today, "Fish and chips", 108, RESTAURANT3);
    public static final Dish DISH_11 = new Dish(DISH_ID + 10, today, "Mint tea", 25, RESTAURANT4);
    public static final Dish DISH_12 = new Dish(DISH_ID + 11, today, "Champagne", 50, RESTAURANT6);
    public static final Dish DISH_13 = new Dish(DISH_ID + 12, today, "Pizza", 45, RESTAURANT3);
    public static final Dish DISH_14 = new Dish(DISH_ID + 13, today, "French fries", 30, RESTAURANT2);
    public static final Dish DISH15 = new Dish(DISH_ID + 14, today, "Cutlet + spaghetti", 62, RESTAURANT4);

    public static final List<Dish> DISHES = Arrays.asList(DISH_1, DISH_2, DISH_3, DISH_4, DISH_5, DISH_6, DISH_7,
            DISH_8, DISH_9, DISH_10, DISH_11, DISH_12, DISH_13, DISH_14, DISH15);

    public static Dish getUpdated() {
        return new Dish(DISH_ID + 4, today, DISH_5.getName(), 11, RESTAURANT3);
    }

    public static Dish getCreated() {
        return new Dish(DISH_ID+17, today, "Creamy Salmon Soup", 48, RESTAURANT3);
    }

    public static void assertMatch(Dish actual, Dish expected) {
        assertThat(actual).isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Dish> actual, Dish... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Dish> actual, Iterable<Dish> expected) {
        assertThat(actual).isEqualTo(expected);
    }
}
