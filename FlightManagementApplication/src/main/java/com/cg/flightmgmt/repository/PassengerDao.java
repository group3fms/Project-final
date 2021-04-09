package com.cg.flightmgmt.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.dto.Passenger;
@Repository
public interface PassengerDao extends CrudRepository<Passenger, BigInteger>{
	@Query("select p from Passenger p where bookingId=?1")
	public List<Passenger> getPassengerList(BigInteger bookingId);
}
