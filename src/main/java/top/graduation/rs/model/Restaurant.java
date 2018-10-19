package top.graduation.rs.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */

@Entity
@Table(name = "restaurants")
public class Restaurant extends AbstractBaseEntity {
    @Column(name = "title", nullable = false, unique = true)
    @Size(min = 2, max = 70)
    @NotBlank
    private String title;
    @Column(name = "location", nullable = false)
    @Size(min = 2, max = 70)
    @NotBlank
    private String location;

    public Restaurant() {
    }

    public Restaurant(Integer id, String title, String location) {
        super(id);
        this.title = title;
        this.location = location;
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

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
