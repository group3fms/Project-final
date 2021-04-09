package com.cg.flightmgmt.repository;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cg.flightmgmt.dto.ScheduledFlight;
@Repository
public interface ScheduledFlightDao extends CrudRepository<ScheduledFlight, BigInteger> {

}
