package com.vash.domaine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import com.vash.entities.Property;

public class PropertyConvert {

	
	public static Property toBo(PropertyVo propertyVo) {
		Property property = null;
		if (!ObjectUtils.isEmpty(propertyVo)) {
			property = new Property();
			property.setId(propertyVo.getId());
			property.setDescription(propertyVo.getDescription());
			property.setEquiped(propertyVo.getEquiped());
			property.setNumberMaxPersons(propertyVo.getNumberMaxPersons());
			property.setNumberRoom(propertyVo.getNumberRoom());
			property.setNumberWC(propertyVo.getNumberWC());
			property.setPrice(propertyVo.getPrice());
			property.setSurface(propertyVo.getSurface());
			property.setVisible(propertyVo.getVisible());
			property.setAddress(AddressConverter.toBo(propertyVo.getAddress()));
			property.setImages(ImageConverter.toListBo(propertyVo.getImages()));
			property.setReservations(ReservationConvert.toListBo(propertyVo.getReservations()));
			property.setReviews(ReviewConverter.toListBo(propertyVo.getReviews()));
			property.setTags(TagsConverter.toListBo(propertyVo.getTags()));
			property.setTypeProperty(TypePropertyConverter.toBo(propertyVo.getTypeProperty()));
			property.setUser(UserConverter.toBo(propertyVo.getUser()));
			property.setCity(CityConverter.toBo(propertyVo.getCity()));
			
		}

		return property;
	}
	
	public static PropertyVo toVo(Property property) {
		PropertyVo propertyVo = null;
		if (!ObjectUtils.isEmpty(property)) {
			propertyVo = new PropertyVo();
			propertyVo.setId(property.getId());
			propertyVo.setDescription(property.getDescription());
			propertyVo.setEquiped(property.getEquiped());
			propertyVo.setNumberMaxPersons(property.getNumberMaxPersons());
			propertyVo.setNumberRoom(property.getNumberRoom());
			propertyVo.setNumberWC(property.getNumberWC());
			propertyVo.setPrice(property.getPrice());
			propertyVo.setSurface(property.getSurface());
			propertyVo.setVisible(property.getVisible());
			propertyVo.setAddress(AddressConverter.toVo(property.getAddress()));
			propertyVo.setImages(ImageConverter.toListVo(property.getImages()));
			propertyVo.setReservations(ReservationConvert.toListVo(property.getReservations()));
			propertyVo.setReviews(ReviewConverter.toListVo(property.getReviews()));
			propertyVo.setTags(TagsConverter.toListVo(property.getTags()));
			propertyVo.setTypeProperty(TypePropertyConverter.toVo(property.getTypeProperty()));
			propertyVo.setUser(UserConverter.toVo(property.getUser()));
			propertyVo.setCity(CityConverter.toVo(property.getCity()));
			
		}

		return propertyVo;
	}
	
	public static List<Property> toListBo(List<PropertyVo> propertyVos) {
		List<Property> propertys = new ArrayList<Property>();
		if (!ObjectUtils.isEmpty(propertyVos)) {
			for (PropertyVo propertyVo : propertyVos) {
				propertys.add(toBo(propertyVo));
			}
			
		}

		return propertys;
	}
	
	
	public static List<PropertyVo> toListVo(List<Property> propertys) {
		List<PropertyVo> propertyVos = new ArrayList<PropertyVo>();
		if (!ObjectUtils.isEmpty(propertys)) {
			for (Property property : propertys) {
				propertyVos.add(toVo(property));
			}
		}

		return propertyVos;
	}
}
