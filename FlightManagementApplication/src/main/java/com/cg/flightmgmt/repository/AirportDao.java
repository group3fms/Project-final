package com.cg.flightmgmt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.cg.flightmgmt.dto.Airport;

@Repository

public interface AirportDao extends CrudRepository<Airport, String> {

}
