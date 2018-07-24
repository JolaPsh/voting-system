package model;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */
public class Vote {
    private final User user;
    private final Restaurant restaurant;

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
