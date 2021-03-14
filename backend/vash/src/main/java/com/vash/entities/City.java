package com.vash.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class City implements Serializable{

	private static final long serialVersionUID = 1059632186186527083L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nameCity;
	
	@OneToOne(mappedBy = "city")
	private Address address;
	
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_city_country"))
	private Country country;
}
