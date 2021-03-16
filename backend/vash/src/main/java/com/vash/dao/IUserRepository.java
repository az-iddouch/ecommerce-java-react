package com.vash.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vash.entities.User;

public interface IUserRepository extends JpaRepository<User, Long>{
	
	User findByUserNameAndPassword(String userName,String password);
	

}
