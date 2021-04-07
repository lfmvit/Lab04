package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class CorsoDAO {
	
	/*
	 * Ottengo tutti i corsi salvati nel Db
	 */
	public ArrayList<Corso> getTuttiICorsi() {  

		final String sql = "SELECT DISTINCT*   FROM corso ORDER BY nome ASC";

		ArrayList<Corso> corsi = new ArrayList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				System.out.println(codins + " " + numeroCrediti + " " + nome + " " + periodoDidattico);
				
				Corso corso= new Corso(codins, numeroCrediti, nome, periodoDidattico);
				corsi.add(corso);
			}
			
			st.close();
			rs.close();
			conn.close();
			
			return corsi;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	
	/*
	 * Dato un codice insegnamento, ottengo il corso
	 */
	public Corso getCorso(Corso c) {
		final String sql = "SELECT * FROM corso WHERE nome= ?";

		Corso corso =null;

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, c.getNome());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");

				
				corso= new Corso(codins, numeroCrediti, nome, periodoDidattico);
				
			}
			
			st.close();
			rs.close();
			conn.close();
			
			return corso;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
		
	

	/*
	 * Ottengo tutti gli studenti iscritti al Corso
	 */
	public ArrayList<Studente> getStudentiIscrittiAlCorso(Corso c) {
		
		final String sql = "SELECT * FROM studente AS s, iscrizione AS i, corso AS c WHERE s.matricola=i.matricola AND c.codins= i.codins AND c.nome=?";

		ArrayList<Studente> studenticorso=new ArrayList<Studente> ();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, c.getNome());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				Integer matricola1= rs.getInt("matricola");
				String cognome = rs.getString("cognome");
				String nome= rs.getString("nome");
				String cds= rs.getString("CDS");

				
				Studente studente= new Studente(matricola1, cognome, nome, cds);
				studenticorso.add(studente);

				
			}
			
			st.close();
			rs.close();
			conn.close();
			
			return studenticorso;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		
	}

	/*
	 * Data una matricola ed il codice insegnamento, iscrivi lo studente al corso.
	 */
	public boolean inscriviStudenteACorso(Studente studente, Corso corso) {
		// TODO
		// ritorna true se l'iscrizione e' avvenuta con successo
		return false;
	}

}
