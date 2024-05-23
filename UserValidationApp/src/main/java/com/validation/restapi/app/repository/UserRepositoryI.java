package com.validation.restapi.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.validation.restapi.app.model.User;

@Repository
public interface UserRepositoryI extends JpaRepository<User, Integer>{
	
	public User getByUserId(Integer userId);
	public User getByUserName(String userName);

}
