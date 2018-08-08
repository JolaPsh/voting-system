package top.graduation.rs.model;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */
public class Dish {
    private final int id;
    private final String name;
    private final int price;
    private final Restaurant restaurant;

    public Dish(int id, String name, int price, Restaurant restaurant) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    public String getName() {
        return name;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
