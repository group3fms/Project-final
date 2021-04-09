package com.cg.flightmgmt.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightmgmt.exception.InvalidUserException;
import com.cg.flightmgmt.exception.RecordAlreadyPresentException;
import com.cg.flightmgmt.exception.RecordNotFoundException;
import com.cg.flightmgmt.exception.UserNotValidException;
import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.service.UserService;

@ComponentScan(basePackages = "com")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
//	adding users
	public User addUser(@RequestBody User newUser) {
		User user=userService.addUser(newUser);
		return user;
	}
//	view all users
	@GetMapping
	public List<User> readAllUsers() {

		return userService.viewUser();
	}
//	update user	
	@PutMapping
	public void updateUser(@RequestBody User updateUser) {

		userService.updateUser(updateUser);
	}
//	view users by id
	@GetMapping("/{id}")
	public User viewUser(@PathVariable("id") BigInteger userId) {

		return userService.viewUser(userId);
	}
//	delete users
	@DeleteMapping("/{id}")
	public void deleteBookingByID(@PathVariable("id") BigInteger userId) {

		userService.deleteUser(userId);
	}
//	validation 
	@GetMapping("signin/{userName}/{password}/{userType}")
	@ExceptionHandler(InvalidUserException.class)
    public ResponseEntity<User> signIn(@PathVariable String userName, @PathVariable String password, @PathVariable String userType) throws InvalidUserException {
        User user1 = userService.signIn(userName, password, userType);
        if (user1.getUserName() != null && user1.getUserPassword() != null && user1.getUserType()!= null) {
            return new ResponseEntity<User>(user1,HttpStatus.OK);
        } else {
            throw new InvalidUserException("Inavlid UserName or password");
        }
    }
	
}