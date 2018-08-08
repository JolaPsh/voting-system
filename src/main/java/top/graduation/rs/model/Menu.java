package top.graduation.rs.model;

import java.util.Set;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */
public class Menu {
    private final int id;
    private final Restaurant restaurant;
    private final Set<Dish> dishSet;


    public Menu(int id, Restaurant restaurant, Set<Dish> dishSet) {
        this.id = id;
        this.restaurant = restaurant;
        this.dishSet = dishSet;
    }
}
