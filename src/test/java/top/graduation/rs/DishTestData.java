package top.graduation.rs;

import top.graduation.rs.model.Dish;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static top.graduation.rs.model.AbstractBaseEntity.START_SEQ;

/**
 * Created by Joanna Pakosh on Окт., 2018
 */

public class DishTestData {

    public static final int DISH_ID = START_SEQ;
    public static final LocalDate today = LocalDate.now();

    public static final Dish DISH_1 = new Dish(DISH_ID, today, "Calamari", 33);
    public static final Dish DISH_2 = new Dish(DISH_ID + 1, today, "Meat balls + Deruny", 112);
    public static final Dish DISH_3 = new Dish(DISH_ID + 2, today, "Cabbage rolls", 52);
    public static final Dish DISH_4 = new Dish(DISH_ID + 3, today, "Omelette", 27);
    public static final Dish DISH_5 = new Dish(DISH_ID + 4, today, "Casserole", 72);
    public static final Dish DISH_6 = new Dish(DISH_ID + 5, today, "Fish and chips", 108);
    public static final Dish DISH_7 = new Dish(DISH_ID + 6, today, "Mint tea", 25);
    public static final Dish DISH_8 = new Dish(DISH_ID + 7, today, "Champagne", 50);
    public static final Dish DISH_9 = new Dish(DISH_ID + 8, today, "Cutlet + spaghetti", 62);

    public static final Object[] DISH_HISTORY_13 = new Object[] {
            new Object [] {LocalDate.now(), "French fries", 30, "Panorama", "herbert@gmail.com"}};

    public static final List<Dish> DISHES = Arrays.asList(DISH_1, DISH_2, DISH_3, DISH_4, DISH_5, DISH_6,
            DISH_7, DISH_8, DISH_9);

    public static Dish getUpdated() {
        return new Dish(DISH_ID + 4, today, DISH_5.getName(), 65);
    }

    public static Dish getCreated() {
        return new Dish(null, today, "Creamy Salmon Soup", 48);
    }

    public static void assertMatch(Dish actual, Dish expected) {
        assertThat(actual).isEqualTo(expected);}

    public static void assertMatch(Iterable<Dish> actual, Dish... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Dish> actual, Iterable<Dish> expected) {
        assertThat(actual).isEqualTo(expected);
    }
}