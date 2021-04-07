package it.polito.tdp.lab04.model;




import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	
	CorsoDAO corsoDao;
	StudenteDAO studenteDao;

	public Model() {
		corsoDao= new CorsoDAO();
		studenteDao= new StudenteDAO();

	}
	
//	public ArrayList<String> getNomeTuttiCorsi(){
//		
//		ArrayList<String> listanomi=new ArrayList<String>();
//
//		for(Corso c: corsoDao.getTuttiICorsi())
//				listanomi.add(c.getNome());
//
//		listanomi.add(0,"");
//		
//	return listanomi;
//	
//	}
	
	public ArrayList<Corso> getTuttiICorsi(){
		return corsoDao.getTuttiICorsi();
	}
	
	public Corso getCorso(Corso c) {
		return corsoDao.getCorso(c);
	
	}
	

	public Studente getStudente(Integer matricola) {
		
		Studente studente= studenteDao.getStudente(matricola);
		if(studente==null)
			return null;
		
	    return studente;
	}
	
	public ArrayList<Studente> getStudentiIscrittiAlCorso(Corso c) {
		return corsoDao.getStudentiIscrittiAlCorso(c);
	}

	
	public ArrayList<Corso> getIscrizioniStudente(Studente s){
		return studenteDao.getIscrizioniStudente(s);
		
	}
	
	public boolean iscriviStudente(Studente s, Corso c) {
		return studenteDao.iscriviStudente(s, c);
	}
	
	
}
