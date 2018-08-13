package top.graduation.rs.model;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */
public class Vote {
    private User user;
    private Restaurant restaurant;

    public Vote() {
    }

    public Vote(User user, Restaurant restaurant) {
        this.user = user;
        this.restaurant = restaurant;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
