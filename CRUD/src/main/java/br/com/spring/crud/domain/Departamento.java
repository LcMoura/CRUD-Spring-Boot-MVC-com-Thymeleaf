package br.com.spring.crud.domain;

import javax.persistence.*;

//Classe Departamento = Extender a Classe AbstractEntity e definir o tipo genérico ID como Long
//Anotação @Entity = transformar a entidade em uma entidade gerenciada pela JPA
//Anotação @Table = incluir o nome da tabela para o Banco de Dados
//@SuppressWarnings = Omitir a implementação do serial, pois quem cuidará será o JPA ao compilar
@SuppressWarnings("serial")
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long> {
	
	// Mapear o atributo nome para a coluna no Banco de Dados
	// nome como o nome da coluna, nullable como obrigatório, unique como única e com 60 caracteres
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}	
}
