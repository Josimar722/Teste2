package com.wk.bora.doar.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//definindo a tabela no Mysql
@Entity
@Table(name = "db_candidato")	
public class Candidatos {
	
//definindo atributos
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

private String nome;

private String idade;

private String peso;

private String altura;

//gerando Gettets e Setters

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getNome() {
	return nome;
}

public void setNome(String nome) {
	this.nome = nome;
}

public String getIdade() {
	return idade;
}

public void setIdade(String idade) {
	this.idade = idade;
}

public String getPeso() {
	return peso;
}

public void setPeso(String peso) {
	this.peso = peso;
}

public String getAltura() {
	return altura;
}

public void setAltura(String altura) {
	this.altura = altura;
}


}
