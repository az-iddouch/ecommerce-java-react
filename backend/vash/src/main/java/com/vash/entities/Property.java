package com.vash.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Property implements Serializable {

	private static final long serialVersionUID = 6643020290706475486L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String price;
	private Boolean equiped;
	private String surface;
	private Integer numberRoom;
	private Integer numberWC;
	private Boolean visible;
	private Integer numberMaxPersons;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_user_id"))
	private User user;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_property_typeProperty"))
	private TypeProperty typeProperty;

	@OneToMany(mappedBy = "property")
	//@Column(name = "imageId")
	private List<Image> images;

	@ManyToMany(mappedBy = "propertys")
	//@Column(name = "tagId")
	private List<Tags> tags;

	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_property_address"))
	private Address address;

	@OneToMany(mappedBy = "property")
	private List<Reservation> reservations;

	@OneToMany(mappedBy = "property")
	private List<Review> reviews;
}
