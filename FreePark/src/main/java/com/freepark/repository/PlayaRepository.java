package com.freepark.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.freepark.domain.Estacionamiento;
import com.freepark.domain.Playa;
import com.freepark.domain.Reserva;

public interface PlayaRepository extends JpaRepository<Playa, Long> {

	@Query("SELECT e FROM Estacionamiento e, Reserva r WHERE e.id = :id AND e.id = r.estacionamiento.id")
	public List<Estacionamiento> findAllByFree(@Param("id")Long playaId);
		
}
