package top.graduation.rs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */
@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Column(name = "id", nullable = false)
    private final int id;
    @Column(name = "title", nullable = false)
    @NotBlank
    private final String title;
    @Column(name = "location", nullable = false)
    @NotBlank
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
