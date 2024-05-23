package com.validation.restapi.app.service;

import java.util.List;

import com.validation.restapi.app.model.User;


public interface UserServiceI {

	User saveUser(User u);

	List<User> getUsers();

	User getUser(Integer userId);

	User deleteUser(Integer userId);

	User getByUserName(String userName);

	User updateUser(Integer userId, User u);

}
