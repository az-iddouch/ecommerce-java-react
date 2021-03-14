package com.vash.entities;

import java.io.Serializable;

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
public class Review implements Serializable{
	
	private static final long serialVersionUID = 7525932076272338061L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double note;
	private String comment;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_review_user"))
	private User user;
	
	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_review_property"))
	private Property property;
}
