package com.freepark.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.freepark.domain.Usuario;
import com.freepark.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl extends ServiceImpl<Usuario, Long>{
	
	@Autowired
	private UsuarioRepository dao;
	
	public Usuario findByUsername(String username) {
		return dao.findByUsername(username);
	}
	
	@Override
	public void create(Usuario entity) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(entity.getPassword());
		entity.setPassword(hashedPassword);
		super.create(entity);
	}
	
	@Override
	public void update(Usuario entity) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(entity.getPassword());
		entity.setPassword(hashedPassword);
		super.update(entity);
	}

	@Override
	public void removeById(Long id) {
		super.removeById(id);
	}

	@Override
	public void remove(Usuario entity) {
		// TODO Auto-generated method stub
		super.remove(entity);
	}

	@Override
	public Usuario findById(Long id) {
		// TODO Auto-generated method stub
		return super.findById(id);
	}

	@Override
	public List<Usuario> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}
	
}
