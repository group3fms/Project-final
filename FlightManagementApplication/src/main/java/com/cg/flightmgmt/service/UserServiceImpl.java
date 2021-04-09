package com.cg.flightmgmt.service;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.lang.*;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.flightmgmt.repository.UserDao;
import com.cg.flightmgmt.exception.InvalidUserException;
import com.cg.flightmgmt.exception.RecordAlreadyPresentException;
import com.cg.flightmgmt.exception.RecordNotFoundException;
import com.cg.flightmgmt.exception.UserNotValidException;
import com.cg.flightmgmt.dto.User;

@Service

public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	// add
	@Override
	public User addUser(User newUser) throws UserNotValidException {
		validateUser(newUser);
		userDao.save(newUser);
		System.out.println(newUser.getUserId());
		return newUser;
	}

	// update
	@Override
	public User updateUser(User updateUser) {
		// TODO Auto-generated method stub
		Optional<User> findUserById = userDao.findById(updateUser.getUserId());
		if (findUserById.isPresent()) {
			userDao.save(updateUser);
		} else
			throw new RecordNotFoundException("User with Id: " + updateUser.getUserId() + " not exists!!");
		return updateUser;
	}

	// delete
	@Override
	public void deleteUser(BigInteger UserId) {
		// TODO Auto-generated method stub
		Optional<User> findBookingById = userDao.findById(UserId);
		if (findBookingById.isPresent()) {
			userDao.deleteById(UserId);

		} else
			throw new RecordNotFoundException("User not found for the entered UserID");
	}

	// getting all Id's
	@SuppressWarnings("null")
	@Override
	public List<User> viewUser() {
		// TODO Auto-generated method stub

		return (List<User>) userDao.findAll();
	}

	// getting user details by Id
	@Override
	public User viewUser(BigInteger UserId) {
		Optional<User> findUserById = userDao.findById(UserId);
		if (findUserById.isPresent()) {

			return findUserById.get();
		} else
			throw new RecordNotFoundException("User Id" + UserId + "not exists");
	}

	// validate
	@Override
	public void validateUser(User user) throws UserNotValidException {
		// TODO Auto-generated method stub

		String phno = user.getUserPhone().toString();

		boolean phnValid;
		if (phno.length() == 10 && phno.charAt(0) != '0') {
			phnValid = true;
		} else {
			phnValid = false;
		}
		boolean emailValid = true;
		String mail = user.getEmail();
		int atPos = mail.indexOf('@');
		for (int i = 0; i < atPos; i++) {
			if ((mail.charAt(i) >= 'a' && mail.charAt(i) <= 'z') && (mail.charAt(i) >= 'A' && mail.charAt(i) <= 'Z')
					&& (mail.charAt(i) >= '0' && mail.charAt(i) <= '9')) {
				emailValid = true;
			} else {
				emailValid = false;
				break;
			}
		}
		if (mail.contains("@") && mail.contains(".")) {
			emailValid = true;

		} else {
			emailValid = false;
		}
		if (!(emailValid && phnValid)) {
			throw new UserNotValidException("Mail/phone not valid");
		}

	}
	//SignIn
	public User signIn(String userName, String password, String userType) throws InvalidUserException
	{
		User signedUser=userDao.signIn(userName, password, userType);
		if (signedUser != null)
		{
//			System.out.println("SignedIn");
            return signedUser;
		}
        else
        {
            throw new InvalidUserException("Invalid userName or Password");
        }
		
	}
}
