package br.com.spring.crud.domain;

import java.io.Serializable;

import javax.persistence.*;

//ID para chave primária
//Transformar todas as classes em Serializable
//@SuppressWarnings = Omitir a implementação do serial, pois quem cuidará será o JPA ao compilar
//@MappedSuperclass = Informar que é uma super classe
@SuppressWarnings("serial")
@MappedSuperclass
public abstract class AbstractEntity <ID extends Serializable> implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-incremento
	private ID id;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity<?> other = (AbstractEntity<?>) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "id = " + id;
	}
}
