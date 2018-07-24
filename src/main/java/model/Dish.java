package model;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */
public class Dish {
    private final int id;
    private final String name;
    private final int price;
    private final Menu menu;

    public Dish(int id, String name, int price, Menu menu) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
    }
}
