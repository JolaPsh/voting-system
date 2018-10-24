package top.graduation.rs.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */

@Entity
@Table(name = "restaurants", uniqueConstraints = {@UniqueConstraint(columnNames="title", name = "restaurant_title_idx")})
public class Restaurant extends AbstractBaseEntity {
    @Column(name = "title", nullable = false, unique = true)
    @Size(min = 2, max = 70)
    @NotBlank
    private String title;
    @Column(name = "location", nullable = false)
    @Size(min = 2, max = 300)
    @NotBlank
    private String location;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dish_id")
    private Dish dish;

    public Restaurant() {
    }

    public Restaurant(String title, String location) {
        this(null, title, location);
    }

    public Restaurant(Integer id, String title, String location) {
        super(id);
        this.title = title;
        this.location = location;
    }

    public Restaurant(Integer id, String title, String location, Dish dish) {
        super(id);
        this.title = title;
        this.location = location;
        this.dish = dish;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", dish=" + dish +
                '}';
    }
}
