package com.ufc.br.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pratos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigoPrato;
	private String nomePrato;
	private double precoPrato;
	
	
	
	
	public Long getCodigoPrato() {
		return codigoPrato;
	}
	public void setCodigoPrato(Long codigoPrato) {
		this.codigoPrato = codigoPrato;
	}
	public String getNomePrato() {
		return nomePrato;
	}
	public void setNomePrato(String nomePrato) {
		this.nomePrato = nomePrato;
	}
	public double getPrecoPrato() {
		return precoPrato;
	}
	public void setPrecoPrato(double precoPrato) {
		this.precoPrato = precoPrato;
	}

	public Pratos() {
	}

	public Pratos(Long codigoPrato, String nomePrato, double precoPrato) {
		this.codigoPrato = codigoPrato;
		this.nomePrato = nomePrato;
		this.precoPrato = precoPrato;
	}
	
}
