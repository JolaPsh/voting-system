package top.graduation.rs.model;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */
public class Restaurant {
    private final int id;
    private final String title;
    private final String location;
    private final Menu menu;

    public Restaurant(int id, String title, String location, Menu menu) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.menu = menu;
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
