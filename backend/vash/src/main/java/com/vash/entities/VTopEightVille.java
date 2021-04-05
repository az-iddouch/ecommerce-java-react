package com.vash.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Vtopeightville")
public class VTopEightVille implements Serializable {

	private static final long serialVersionUID = 6944368029270637817L;
	@Id
	private Long cityId;
	private String nameCity;
	private Long countryId;
	private Integer counter;
}
