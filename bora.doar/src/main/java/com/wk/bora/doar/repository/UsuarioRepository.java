package com.wk.bora.doar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wk.bora.doar.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByEmail(String email);


}
