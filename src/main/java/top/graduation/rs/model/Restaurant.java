package top.graduation.rs.model;

import java.util.Set;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */
public class Restaurant {
    private final int id;
    private final String title;
    private final String location;
    private final Set<Dish> dishes;

    public Restaurant(int id, String title, String location, Set<Dish> dishes) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.dishes = dishes;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }
}
