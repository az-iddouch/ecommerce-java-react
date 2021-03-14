package com.vash.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
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
public class Image implements Serializable {

	private static final long serialVersionUID = -3913115777701741888L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String url;

	@ManyToOne
	@JoinTable(name = "propertyImage", joinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "fk_image_property")), inverseJoinColumns = @JoinColumn(foreignKey = @ForeignKey(name = "fk_property_image")))
	private Property property;

	@OneToOne(mappedBy = "image")
	private User user;

	@OneToOne(mappedBy = "image")
	private Tags tag;
}
