package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	public StudenteDAO() {	
	}
	
	public Studente getStudente(Integer matricola) {
		
		String sql= "SELECT * FROM studente WHERE matricola= ?";
		Studente studente = null;
				
				try {
					
					Connection conn = ConnectDB.getConnection();
					PreparedStatement st = conn.prepareStatement(sql);
					st.setString(1, String.valueOf(matricola));
					ResultSet rs = st.executeQuery();

					if (rs.next()) {
						
						Integer matricola1= rs.getInt("matricola");
						String cognome = rs.getString("cognome");
						String nome= rs.getString("nome");
						String cds= rs.getString("CDS");

						studente= new Studente(matricola1, cognome, nome, cds);
						
					}
					
					conn.close();
					return studente;
					
						}catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore Db", e);
	}
}
	
	
	public ArrayList<Corso> getIscrizioniStudente(Studente s) {
		
		String sql="SELECT nome FROM  iscrizione AS i, corso AS c WHERE c.codins=i.codins AND matricola=?";
		ArrayList<Corso> iscrizioni= new ArrayList<Corso>();
		
		try {
			
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, String.valueOf(s.getMatricola()));
			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String nome = rs.getString("nome");		
				Corso corso= new Corso(nome);
				iscrizioni.add(corso);				
			}
			
			conn.close();
			return iscrizioni;
			
				}catch (SQLException e) {
					// e.printStackTrace();
				 throw new RuntimeException("Errore Db", e);
				}
	
	}
	
	
	  public boolean iscriviStudente(Studente s,Corso c) {

			String sql= "SELECT * FROM iscrizione WHERE matricola=? AND codins=?";
		
					
					try {
						
						Connection conn = ConnectDB.getConnection();
						PreparedStatement st = conn.prepareStatement(sql);
						st.setInt(1, s.getMatricola());
						st.setString(2, c.getCodins());
						ResultSet rs = st.executeQuery();

						if (rs.next()) {
							
							
							conn.close();
							st.close();
							return false;
							
						}else {
							
							String sql2= "INSERT INTO iscrizione(matricola,codins) VALUES (?,?)";
							PreparedStatement st2 = conn.prepareStatement(sql2);
							st2.setInt(1, s.getMatricola());
							st2.setString(2, c.getCodins());
							st2.executeQuery();
							
							
							
							st2.close();							
							conn.close();
							st.close();
							
							return true;
						}
						
						
						
							}catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		  
	  }

}
