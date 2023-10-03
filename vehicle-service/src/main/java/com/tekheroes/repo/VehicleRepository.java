package com.tekheroes.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tekheroes.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, String> {

	@Query("FROM Vehicle WHERE available=true")
	List<Vehicle> findByAvailable();
}
