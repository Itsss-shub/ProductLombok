package com.validation.restapi.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.validation.restapi.app.exception.UserNotFoundExcetion;
import com.validation.restapi.app.model.User;
import com.validation.restapi.app.repository.UserRepositoryI;
import com.validation.restapi.app.service.UserServiceI;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl implements UserServiceI{

	@Autowired
	UserRepositoryI uri;

	@Override
	public User saveUser(@Valid User u) {
		
		return uri.save(u);
	}

	@Override
	public List<User> getUsers() {
		
		return uri.findAll();
	}

	@Override
	public User getUser(Integer userId)
	{
		User ur = uri.getByUserId(userId);
		if(ur!=null) {
			return ur;
		}
		else {
		throw new UserNotFoundExcetion("not details found on this id ..!!");
		}
	}

	@Override
	public User deleteUser(Integer userId) {
		User ur = uri.getByUserId(userId);
		if(ur!=null) {
			uri.delete(ur);
			return ur;
		}
		else {
		throw new UserNotFoundExcetion("not details found on this id ..!!");
		}
	}

	@Override
	public User getByUserName(String userName) {
	
		User ur = uri.getByUserName(userName);
		if(ur!=null) {
			return ur;
		}
		else {
		throw new UserNotFoundExcetion("not details found on this name ..!!");
		}
	}

	@Override
	public User updateUser(Integer userId, User u) {
		User ur = uri.getByUserId(userId);
		if(ur!=null) {
			if(u.getUserName()!=null) {
				ur.setUserName(u.getUserName());
			}
			if(u.getUserAdhar()!=null) {
				ur.setUserAdhar(u.getUserAdhar());
			}
			if(u.getUserEmail()!=null) {
				ur.setUserEmail(u.getUserEmail());
			}
			if(u.getUserContact()!=null) {
				ur.setUserContact(u.getUserContact());
			}
			if(u.getUserPan()!=null) {
				ur.setUserPan(u.getUserPan());
			}
			
			return uri.save(ur);
		}
		else {
		throw new UserNotFoundExcetion("not details found on this id ..!!");
		}
	}
	
}
