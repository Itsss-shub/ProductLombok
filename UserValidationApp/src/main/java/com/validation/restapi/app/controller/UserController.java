package com.validation.restapi.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.validation.restapi.app.model.User;
import com.validation.restapi.app.service.UserServiceI;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/restapi/user")
public class UserController {

	@Autowired
	UserServiceI usi;
	
	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@Valid@RequestBody User u){
		
		User ur = usi.saveUser(u);
		System.out.println("User saved.....");
		return new ResponseEntity<User> (ur,HttpStatus.OK);
	}
	
	@GetMapping("/getUsers")
	public ResponseEntity<List<User>> getUsers(){
		List<User> clist=usi.getUsers();
		return new ResponseEntity<List<User>>(clist,HttpStatus.OK);
	}
	
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<User> getUser(@PathVariable Integer userId){
		
		User cr=usi.getUser(userId);
		return new ResponseEntity<User> (cr,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<User>deleteUser(@PathVariable Integer userId){
		User cr=usi.deleteUser(userId);
		return new ResponseEntity<User>(cr,HttpStatus.OK);
	}
	
	
	@PutMapping("/updateCustomer/{customerId}")
	public ResponseEntity<User>updateUser(@PathVariable Integer userId,@Valid@RequestBody User u){
		User cr=usi.updateUser(userId,u);
		return new ResponseEntity<User>(cr,HttpStatus.OK);
	}
	
	@GetMapping("/getByUserName/{userName}")
	public ResponseEntity<User> getByUserName(@PathVariable String userName){
		
		User cr=usi.getByUserName(userName);
		return new ResponseEntity<User>(cr,HttpStatus.OK);
	}
	
}
