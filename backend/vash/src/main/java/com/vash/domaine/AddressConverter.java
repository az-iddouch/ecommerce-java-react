package com.vash.domaine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import com.vash.entities.Address;

public class AddressConverter {

	public static Address toBo(AddressVo addressVo) {
		Address address=null;
		if(!ObjectUtils.isEmpty(addressVo)) {
			address=new Address();
			address.setId(addressVo.getId());
			address.setAddress(addressVo.getAddress());
			address.setCity(CityConverter.toBo(addressVo.getCity()));
			address.setProperty(PropertyConvert.toBo(addressVo.getProperty()));
			
		}
		return address;
	}
	
	public static AddressVo toVo(Address address) {
		AddressVo addressVo=null;
		if(!ObjectUtils.isEmpty(address)) {
			addressVo=new AddressVo();
			addressVo.setId(address.getId());
			addressVo.setAddress(address.getAddress());
			addressVo.setCity(CityConverter.toVo(address.getCity()));
			addressVo.setProperty(PropertyConvert.toVo(address.getProperty()));
		}
		return addressVo;
	}
	
	public static List<AddressVo> toListVo(List<Address> address) {
		List<AddressVo> addressVos=new ArrayList<AddressVo>();
		if(!ObjectUtils.isEmpty(address)) {
			for (Address addres : address) {
				addressVos.add(toVo(addres));
			}
		}
		return addressVos;
	}
	
	
	public static List<Address> toListBo(List<AddressVo> addressVo) {
		List<Address> address=new ArrayList<Address>();
		if(!ObjectUtils.isEmpty(addressVo)) {
			for (AddressVo addresVo : addressVo) {
				address.add(toBo(addresVo));
			}
			
		}
		return address;
	}
}
