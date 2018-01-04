package com.freepark.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freepark.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {	
	Usuario findByUsername(String username);
}
