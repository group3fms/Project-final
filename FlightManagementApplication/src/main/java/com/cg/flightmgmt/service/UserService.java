package com.cg.flightmgmt.service;
import java.math.BigInteger;
import java.util.List;

import org.springframework.http.ResponseEntity;
import com.cg.flightmgmt.dto.User;
import com.cg.flightmgmt.exception.InvalidUserException;

public interface UserService {
	public User addUser(User newUser);//user
	
	public User viewUser(BigInteger UserId);
	
	public List<User> viewUser();

	public User updateUser(User newUser);

	public void deleteUser(BigInteger UserId);//void


	public void validateUser(User user);//void
	
	public User signIn(String userName, String password, String userType) throws InvalidUserException;
}
