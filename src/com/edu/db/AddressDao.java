/*
 * 	Created Date: 2020-09-19
 * 	Author: Dodo (rabbit.white at daum dot net)
 * 	Subject: Addressbook DB 처리
 * 	Filename: AddressDao.java
 *  	Description: 
 *  	1. MyBatis 적용함.
 *     2. MyBatis는  (영속 프레임워크) - 데이터베이스처리를 돕기 위함.
 *  
 */

package com.edu.db;
import java.io.*;
import java.util.*;
import org.apache.ibatis.io.*;
import org.apache.ibatis.session.*;

public class AddressDao {
	
	private AddressDao() {}
    private static AddressDao dao;

    public static AddressDao getInstance(){

        if(dao == null){
            dao = new AddressDao();
        }

        return dao;
    }
    
    // SQL 세션 열기
    SqlSessionFactory factory = SqlMapSessionFactory.getSqlSessionFactory();

    public AddressDto selectAddress(Integer num) {

        SqlSession session = factory.openSession();

        AddressDto addressDTO = session.selectOne("com.edu.db.mappers.addressMapper.selectAddress", num);
        session.close();

        return addressDTO;

    }

 

    public int updateAddress(AddressDto addressDTO) {

        SqlSession session = factory.openSession();

        int update = session.update("com.edu.db.mappers.addressMapper.updateAddress", addressDTO);

        // update나 delete의 경우 반드시 커밋 필요.
        // session.commit();을 해주거나 factory.openSession(true);로 설정하면 자동 커밋된다.
        session.commit(); 
        session.close();

        return update;

    }
    
    
    public int insertAddress(AddressDto addressDTO) {
    	
    	SqlSession session = factory.openSession();
    	int insert = session.insert("com.edu.db.mappers.addressMapper.insertAddress", addressDTO);
    	
    	session.commit();
    	session.close();
    	
    	return insert;
    	
    }
    
    public int deleteAddress(Integer num) {
    	
    	SqlSession session = factory.openSession();
    	int delete = session.delete("com.edu.db.mappers.addressMapper.deleteAddress", num);
    	
    	session.commit();
    	session.close();
    	
    	return delete;
    }

}