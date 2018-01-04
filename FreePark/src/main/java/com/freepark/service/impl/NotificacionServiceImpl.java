package com.freepark.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freepark.domain.Notificacion;
import com.freepark.repository.NotificacionRepository;


@Service
public class NotificacionServiceImpl extends ServiceImpl<Notificacion, Long> {
	
	@Autowired
	private NotificacionRepository dao;

	@Override
	public void create(Notificacion entity) {
		// TODO Auto-generated method stub
		super.create(entity);
	}

	@Override
	public void remove(Notificacion entity) {
		// TODO Auto-generated method stub
		super.remove(entity);
	}

	@Override
	public void update(Notificacion entity) {
		// TODO Auto-generated method stub
		super.update(entity);
	}

	@Override
	public Notificacion findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<Notificacion> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}

	@Override
	public void removeById(Long id) {
		// TODO Auto-generated method stub
		super.removeById(id);
	}
	
	public Notificacion findByIdEmisorAndIdReceptor(long idEmisor, long idReceptor){
		return dao.findByIdEmisorAndIdReceptor(idEmisor, idReceptor);
	}

}
