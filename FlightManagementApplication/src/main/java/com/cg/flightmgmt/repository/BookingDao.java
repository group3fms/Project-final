package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.dto.Booking;

@Repository
public interface BookingDao extends CrudRepository<Booking, BigInteger> {

}
