package com.cg.flightmgmt.repository;

import java.math.BigInteger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.flightmgmt.dto.Flight;

@Repository
public interface FlightDao extends CrudRepository<Flight,BigInteger>{

}
