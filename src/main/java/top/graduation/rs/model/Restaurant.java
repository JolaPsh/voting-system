package top.graduation.rs.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;

import top.graduation.rs.View;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */

@Entity
@Table(name = "restaurants", uniqueConstraints = { @UniqueConstraint(columnNames = "title", name = "restaurant_title_idx") })
public class Restaurant extends AbstractBaseEntity {
	@Column(name = "title", nullable = false, unique = true)
	@Size(min = 2, max = 70)
	@NotBlank
	@JsonView(View.Summary.class)
	private String title;
	@Column(name = "location", nullable = false)
	@Size(min = 2, max = 300)
	@NotBlank
	@JsonView(View.Summary.class)
	private String location;
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@OneToMany(fetch = FetchType.LAZY, mappedBy="restaurant")
	@OrderBy("date DESC")
	@JsonManagedReference
	@JsonView(View.SummaryWithDishes.class)
	private List<Dish> dishes;

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

	public List<Dish> getDishes() {
		return this.dishes;
	}

	@Override
	public String toString() {
		return "Restaurant [title=" + title + ", location=" + location + "]";
	}
}
