package it.polito.tdp.lab04.model;

public class Corso {
	String codins;
	Integer numerocrediti;
	String nome;
	Integer pd;
	
	public Corso(String codins, Integer numerocrediti, String nome, Integer pd) {
		this.codins = codins;
		this.numerocrediti = numerocrediti;
		this.nome = nome;
		this.pd = pd;
	}
	
	public Corso(String nome) {
		this.nome= nome;
	}

	@Override
	public String toString() {
		return nome+" "+codins;
	}
	public void setCodins(String codins) {
		this.codins = codins;
	}
	public void setNumerocrediti(Integer numerocrediti) {
		this.numerocrediti = numerocrediti;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPd(Integer pd) {
		this.pd = pd;
	}
	public String getCodins() {
		return codins;
	}
	public Integer getNumerocrediti() {
		return numerocrediti;
	}
	public String getNome() {
		return nome;
	}
	public Integer getPd() {
		return pd;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codins == null) ? 0 : codins.hashCode());
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
		Corso other = (Corso) obj;
		if (codins == null) {
			if (other.codins != null)
				return false;
		} else if (!codins.equals(other.codins))
			return false;
		return true;
	}
	

}
