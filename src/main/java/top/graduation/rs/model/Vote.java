package top.graduation.rs.model;

import java.time.LocalDateTime;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */
public class Vote {
    private User user;
    private Restaurant restaurant;
    private LocalDateTime dateTime;

    public Vote() {
    }

    public Vote(User user, Restaurant restaurant, LocalDateTime dateTime) {
        this.user = user;
        this.restaurant = restaurant;
        this.dateTime = dateTime;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
