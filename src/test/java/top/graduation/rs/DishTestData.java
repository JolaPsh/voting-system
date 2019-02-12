package top.graduation.rs;

import static org.assertj.core.api.Assertions.assertThat;
import static top.graduation.rs.RestaurantTestData.RESTAURANT_1;
import static top.graduation.rs.RestaurantTestData.RESTAURANT_2;
import static top.graduation.rs.RestaurantTestData.RESTAURANT_3;
import static top.graduation.rs.RestaurantTestData.RESTAURANT_4;
import static top.graduation.rs.RestaurantTestData.RESTAURANT_5;
import static top.graduation.rs.RestaurantTestData.RESTAURANT_6;
import static top.graduation.rs.RestaurantTestData.RESTAURANT_7;
import static top.graduation.rs.TestUtil.TODAY;
import static top.graduation.rs.model.AbstractBaseEntity.START_SEQ;

import java.util.Arrays;
import java.util.List;

import top.graduation.rs.model.Dish;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */

public class DishTestData {

    public static final int DISH_ID = START_SEQ + 7;

    public static final Dish DISH_1 = new Dish(DISH_ID, TODAY, "Calamari", 33, RESTAURANT_2);
    public static final Dish DISH_2 = new Dish(DISH_ID + 1, TODAY, "Meat balls + Deruny", 112, RESTAURANT_1);
    public static final Dish DISH_3 = new Dish(DISH_ID + 2, TODAY, "Cabbage rolls", 52, RESTAURANT_3);
    public static final Dish DISH_4 = new Dish(DISH_ID + 3, TODAY, "Omelette", 27, RESTAURANT_1);
    public static final Dish DISH_5 = new Dish(DISH_ID + 4, TODAY, "Casserole", 72, RESTAURANT_4);
    public static final Dish DISH_6 = new Dish(DISH_ID + 5, TODAY, "Fish and chips", 108, RESTAURANT_7);
    public static final Dish DISH_7 = new Dish(DISH_ID + 6, TODAY, "Mint tea", 25, RESTAURANT_6);
    public static final Dish DISH_8 = new Dish(DISH_ID + 7, TODAY, "Champagne", 50, RESTAURANT_5);
    public static final Dish DISH_9 = new Dish(DISH_ID + 8, TODAY, "Cutlet + spaghetti", 62, RESTAURANT_2);

    public static final List<Dish> DISHES = Arrays.asList(DISH_1, DISH_2, DISH_3, DISH_4, DISH_5, DISH_6,
            DISH_7, DISH_8, DISH_9);

    public static Dish getUpdated() {
        return new Dish(DISH_ID + 4, TODAY, DISH_5.getName(), 65);
    }

    public static Dish getCreated() {
        return new Dish(null, TODAY, "Creamy Salmon Soup", 48, RESTAURANT_3);
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