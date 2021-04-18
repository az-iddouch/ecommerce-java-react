package com.vash.domaine;

import java.util.ArrayList;
import java.util.List;

import com.vash.entities.VTopEightVille;

public class VTopEightVilleConverter {

	public static VTopEightVille toBo(VTopEightVilleVo vTopEightVilleVo) {
		VTopEightVille vTopEightVille = new VTopEightVille();
		vTopEightVille.setCityId(vTopEightVilleVo.getCityId());
		vTopEightVille.setCounter(vTopEightVilleVo.getCounter());
		vTopEightVille.setCountryId(vTopEightVilleVo.getCountryId());
		vTopEightVille.setNameCity(vTopEightVilleVo.getNameCity());
		vTopEightVille.setUrl(vTopEightVilleVo.getUrl());
		return vTopEightVille;
	}

	public static VTopEightVilleVo toVo(VTopEightVille vTopEightVille) {
		VTopEightVilleVo vTopEightVilleVo = new VTopEightVilleVo();
		vTopEightVilleVo.setCityId(vTopEightVille.getCityId());
		vTopEightVilleVo.setCounter(vTopEightVille.getCounter());
		vTopEightVilleVo.setCountryId(vTopEightVille.getCountryId());
		vTopEightVilleVo.setNameCity(vTopEightVille.getNameCity());
		vTopEightVilleVo.setUrl(vTopEightVille.getUrl());
		return vTopEightVilleVo;
	}

	public static List<VTopEightVilleVo> toListVo(List<VTopEightVille> vTopEightVilles) {
		List<VTopEightVilleVo> vTopEightVilleVos = new ArrayList<VTopEightVilleVo>();
		for (VTopEightVille vTopEightVille : vTopEightVilles) {
			vTopEightVilleVos.add(toVo(vTopEightVille));
		}
		return vTopEightVilleVos;
	}
	
	public static List<VTopEightVille> toListBo(List<VTopEightVilleVo> vTopEightVilleVos) {
		List<VTopEightVille> vTopEightVilles = new ArrayList<VTopEightVille>();
		for (VTopEightVilleVo vTopEightVilleVo : vTopEightVilleVos) {
			vTopEightVilles.add(toBo(vTopEightVilleVo));
		}
		return vTopEightVilles;
	}
	
	
}
