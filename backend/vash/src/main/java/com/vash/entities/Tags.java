package com.vash.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
public class Tags implements Serializable{

	private static final long serialVersionUID = 6965740487720052761L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nameTag;
	
	@ManyToMany
	@JoinTable(name="tagsProperty",
	joinColumns=@JoinColumn(foreignKey = @ForeignKey(name="fk_tags_property")),
    inverseJoinColumns = @JoinColumn(foreignKey  =@ForeignKey(name="fk_property_tags")))
	private List<Property> propertys = new ArrayList<>();
	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_tags_image"))
	private Image image;
	
}
