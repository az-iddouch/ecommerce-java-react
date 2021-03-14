package com.vash.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Reservation implements Serializable{

	private static final long serialVersionUID = -5942847065220277846L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numberPersons;
	private Date dateStart;
	private Date dateEnd;
	private String status;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_reservation_property"))
	private Property property;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_reservation_user"))
	private User user;
}
