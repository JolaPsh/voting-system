package top.graduation.rs.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */
@Entity
@Table(name = "votes")
public class Vote extends AbstractBaseEntity {
    @ManyToOne
    @JoinColumn
    @NotNull
    private User user;
    @ManyToOne
    @JoinColumn
    @NotNull
    private Restaurant restaurant;
    @Column(name = "dateTime")
    private LocalDateTime dateTime;

    public Vote() {
    }

    public Vote(Integer id, User user, Restaurant restaurant, LocalDateTime dateTime) {
        super(id);
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
