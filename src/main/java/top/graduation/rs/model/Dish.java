package top.graduation.rs.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */

@Entity
@Table(name = "dishes", uniqueConstraints = {@UniqueConstraint(columnNames="name", name = "dish_name_idx")})
public class Dish extends AbstractNamedEntity {
    @Column(name = "date", nullable = false)
    @NotNull
    private LocalDate date;
    @Column(name = "price", nullable = false)
    @Range(min = 10, max = 50000)
    private int price;

    public Dish() {
    }

    public Dish(Integer id, LocalDate date, String name, int price) {
        super(id, name);
        this.date = date;
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}
