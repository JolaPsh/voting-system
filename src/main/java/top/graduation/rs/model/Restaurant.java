package top.graduation.rs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "restaurants")
public class Restaurant {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "title", nullable = false)
    @Size(min = 2, max = 50)
    @NotBlank
    private String title;
    @Column(name = "location", nullable = false)
    @Size(min = 2, max = 70)
    @NotBlank
    private String location;

    public Restaurant() {
    }

    public Restaurant(int id, String title, String location) {
        this.id = id;
        this.title = title;
        this.location = location;
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
}
