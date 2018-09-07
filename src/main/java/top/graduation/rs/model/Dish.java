package top.graduation.rs.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */

@Entity
@Table(name = "dishes")
public class Dish extends AbstractNamedEntity {
    @Column(name = "date_time", nullable = false)
    @NotNull
    private LocalDateTime dateTime;
    @Column(name = "price", nullable = false)
    @Range(min = 10, max = 2000)
    private int price;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    @NotNull
    private Restaurant restaurant;

    public Dish() {
    }

    public Dish(Integer id, LocalDateTime dateTime, String name, int price, Restaurant restaurant) {
        super(id, name);
        this.dateTime = dateTime;
        this.price = price;
        this.restaurant = restaurant;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
