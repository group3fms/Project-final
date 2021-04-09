package com.cg.flightmgmt.repository;
import java.math.BigInteger;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.dto.User;
@Repository
public interface UserDao extends CrudRepository<User, BigInteger> {
	@Query("select u from User u where userName=?1 and password=?2 and userType=?3 ")
    public User signIn(String userName,String password, String userType);

}
