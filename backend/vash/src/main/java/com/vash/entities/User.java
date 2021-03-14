package com.vash.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "T_USER")
public class User implements Serializable {

	private static final long serialVersionUID = -4354710475330676437L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password;
	private String phoneNumber1;
	private String phoneNumber2;

	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_role_user_id")), inverseJoinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "fk_user_role_role_id")))
	private List<Role> roles;

	@OneToMany(mappedBy = "user")
	private List<Property> propertys;
	
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_user_image"))
	private Image image;
	
	@OneToMany(mappedBy = "user")
	private List<Reservation> reservations;
	
	@OneToMany(mappedBy = "user")
	private List<Review> reviews;
}
