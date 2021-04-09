package com.cg.flightmgmt.dto;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	private BigInteger userId;
	private String userType;
	private String userName;
	private String password;
	private String email;
	private BigInteger userPhone;
	



	/**
	 * Unparameterized Constructor of User
	 */
	public User() {
	}

	/**
	 * Parameterized Constructors of Users
	 */

	public User(BigInteger userId, String userType, String userName, String password, String email,
			BigInteger userPhone) {
		super();
		this.userId = userId;
		this.userType = userType;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.userPhone = userPhone;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public BigInteger getUserId() {
		return userId;
	}

	public void setUserId(BigInteger userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public BigInteger getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(BigInteger userPhone) {
		this.userPhone = userPhone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
//	ToString
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userType=" + userType + ", userName=" + userName + ", password=" + password
				+ ", email=" + email + ", userPhone=" + userPhone + "]";
	}
	

}
