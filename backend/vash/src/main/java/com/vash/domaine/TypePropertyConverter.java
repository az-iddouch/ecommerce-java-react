package com.vash.domaine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import com.vash.entities.TypeProperty;

public class TypePropertyConverter {

	public static TypeProperty toBo(TypePropertyVo typePropertyVo) {
		TypeProperty typeProperty = null;
		if (!ObjectUtils.isEmpty(typePropertyVo)) {
			typeProperty = new TypeProperty();
			typeProperty.setId(typePropertyVo.getId());
			typeProperty.setType(typePropertyVo.getType());
			typeProperty.setPropertys(PropertyConvert.toListBo(typePropertyVo.getPropertys()));
		}

		return typeProperty;
	}

	public static TypePropertyVo toVo(TypeProperty typeProperty) {
		TypePropertyVo typePropertyVo = null;
		if (!ObjectUtils.isEmpty(typeProperty)) {
			typePropertyVo = new TypePropertyVo();
			typePropertyVo.setId(typeProperty.getId());
			typePropertyVo.setType(typeProperty.getType());
			typePropertyVo.setPropertys(PropertyConvert.toListVo(typeProperty.getPropertys()));
		}

		return typePropertyVo;
	}

	public static List<TypePropertyVo> toListVo(List<TypeProperty> typePropertys) {
		List<TypePropertyVo> typePropertyVos = new ArrayList<TypePropertyVo>();
		if (!ObjectUtils.isEmpty(typePropertys)) {
			for (TypeProperty typeProperty : typePropertys) {
				typePropertyVos.add(toVo(typeProperty));
			}

		}

		return typePropertyVos;
	}

	public static List<TypeProperty> toListBo(List<TypePropertyVo> typePropertyVos) {
		List<TypeProperty> typePropertys = new ArrayList<TypeProperty>();
		if (!ObjectUtils.isEmpty(typePropertyVos)) {
			for (TypePropertyVo typePropertyVo : typePropertyVos) {
				typePropertys.add(toBo(typePropertyVo));
			}
		}

		return typePropertys;
	}

}
