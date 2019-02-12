package top.graduation.rs.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by Joanna Pakosh on Июль, 2018
 */

@Entity
@Table(name = "users", uniqueConstraints = {
		@UniqueConstraint(columnNames = "email", name = "users_unique_email_idx") })
public class User extends AbstractNamedEntity {
	@Column(name = "email", nullable = false, unique = true)
	@Email
	@NotBlank
	private String email;
	@Column(name = "registered", columnDefinition = "timestamp default now()")
	@NotNull
	@JsonIgnore
	private LocalDate registered;
	@Column(name = "password", nullable = false)
	@NotBlank
	@Size(min = 5, max = 60)
	@JsonIgnore
	private String password;
	@Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
	private boolean enabled = true;
	@Enumerated(EnumType.STRING)
	@CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "role")
	@ElementCollection(fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<Role> roles;

	public User() {
	}

	public User(Integer id, String name) {
		super(id, name);
	}

	public User(User u) {
		this(u.getId(), u.getName(), u.getEmail(), u.getRegistered(), u.getPassword(), u.isEnabled(), u.getRoles());
	}

	public User(Integer id, String name, String email, String password, Role role, Role... roles) {
		this(id, name, email, LocalDate.now(), password, true, EnumSet.of(role, roles));
	}

	public User(Integer id, String name, String email, LocalDate registered, String password, boolean enabled,
			Collection<Role> roles) {
		super(id, name);
		this.email = email;
		this.registered = registered;
		this.password = password;
		this.enabled = enabled;
		setRoles(roles);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getRegistered() {
		return registered;
	}

	public void setRegistered(LocalDate registered) {
		this.registered = registered;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = CollectionUtils.isEmpty(roles) ? Collections.emptySet() : EnumSet.copyOf(roles);
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", email='" + email + '\'' + ", registered=" + registered + ", password='"
				+ password + '\'' + ", enabled=" + enabled + ", roles=" + roles + '}';
	}
}