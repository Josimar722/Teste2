package com.wk.bora.doar.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.wk.bora.doar.model.Candidatos;
import com.wk.bora.doar.model.Usuario;
import com.wk.bora.doar.model.UsuarioLogin;
import com.wk.bora.doar.repository.CandidatoRepository;
import com.wk.bora.doar.service.UsuarioService;

//Criando atalho via RestController, definindo o endpoint pelo requestMapping e deixando acessar os metodos via Crossorigin
@RestController
@RequestMapping("/candidatos")
@CrossOrigin("*")
public class CandidatoController {
	
	//Criando interração ao banco de dados
	@Autowired CandidatoRepository repository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	//metodo para trazer todos os candidatos
	@GetMapping
	public ResponseEntity<List<Candidatos>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//trazendo todos os candidatos
	@GetMapping("/{id}")
	public ResponseEntity<Candidatos>GetById(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	
	}
	
	//Cadastrando os candidatos
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> post(@RequestBody Usuario usuario){
		Optional<Usuario> user = usuarioService.CadastrarUsuario(usuario);
		try {
				return ResponseEntity.ok(user.get());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	//logando com email e senha
	@PostMapping("/login")
	public ResponseEntity<UsuarioLogin> Autentication (@RequestBody Optional<UsuarioLogin> user){
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PutMapping
	public ResponseEntity<Candidatos> put (@RequestBody Candidatos candidatos){
	return ResponseEntity.status(HttpStatus.OK).body(repository.save(candidatos));
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
	
}
