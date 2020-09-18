/*
 * 	Created Date: 2020-09-19
 * 	Author: Dodo (rabbit.white at daum dot net)
 * 	Subject: Address.java의 구현부
 * 	Filename: AddressImpl.java
 *  	Description: 
 *  	1. Interface: Address.java에 정의됨.
 *  
 */

package com.edu.db;

public class AddressImpl implements Address {

	AddressDao dao = AddressDao.getInstance();
	
	@Override
	public AddressDto getAddress(Integer num) {
		return dao.selectAddress(num);
	}

	@Override
	public int updateAddress(AddressDto addressDTO) {
		
		return dao.updateAddress(addressDTO);
	}
	
	@Override
	public int insertAddress(AddressDto addressDTO) {
		return dao.insertAddress(addressDTO);
	}
	
	@Override
	public int deleteAddress(Integer num) {
		return dao.deleteAddress(num);
	}

}
