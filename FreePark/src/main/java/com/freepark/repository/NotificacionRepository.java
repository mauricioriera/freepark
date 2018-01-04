package com.freepark.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.freepark.domain.Notificacion;

public interface NotificacionRepository extends JpaRepository<Notificacion, Long>{
	
	Notificacion findByIdEmisorAndIdReceptor(long idEmisor, long idReceptor);
	
	

}
