package com.wk.bora.doar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wk.bora.doar.model.Candidatos;

//interação com banco de dados
@Repository
public interface CandidatoRepository extends JpaRepository<Candidatos, Long>{

	public List<Candidatos> findAll();

    
	
}
