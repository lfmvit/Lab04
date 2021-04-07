package it.polito.tdp.lab04.model;

public class Studente {
	Integer matricola;
	String cognome;
	String nome;
	String cds;
	
	public Studente(Integer matricola, String cognome, String nome, String cds) {
	
		this.matricola = matricola;
		this.cognome = cognome;
		this.nome = nome;
		this.cds = cds;
		
	}

	public void setMatricola(Integer matricola) {
		this.matricola = matricola;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCds(String cds) {
		this.cds = cds;
	}

	public Integer getMatricola() {
		return matricola;
	}

	public String getCognome() {
		return cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getCds() {
		return cds;
	}

	@Override
	public String toString() {
		return  matricola+" "+nome+" "+cognome+" "+cds+"\n";
	}
	

}
