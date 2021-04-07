package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> comboCorso;

    @FXML
    private Button btnCercaIscrittiCorso;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnCercaNome;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtCognome;

    @FXML
    private Button btnCerca;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doCercaCorsi(ActionEvent event) {
    	
    	Integer matricola=null;
    	
    	try{ matricola=Integer.parseInt(txtMatricola.getText()) ;
    	
    	}catch(NumberFormatException nfe){
    		txtResult.setText("Ma che cazzo fai?");
    			return;
    	}
    	Studente studente = model.getStudente(matricola);
    	
    	if(studente==null) {
    		txtResult.setText("Nessuno studente corrispondente trovato");
    		return;
    	}else { 
    			ArrayList<Corso> iscrizioni= model.getIscrizioniStudente(studente);
    			String info="";
        		
        		for(Corso c :iscrizioni) {
        			info+=c.toString()+"\n";
        		}

        		txtResult.setText(info);
        		return;
  		
    	}

    }

    @FXML
    void doCercaIscrittiCorso(ActionEvent event) {
    	Corso c= (comboCorso.getValue());
    	
    	if(c==null|| c.getNome().equals("") ) {
    		txtResult.setText("Selezionare un corso!");
    	return;
    	}
    	
    	ArrayList<Studente> iscritti= model.getStudentiIscrittiAlCorso(c);
    	
    	
    	if(iscritti.size()==0) {
    		txtResult.setText("Il corso selezionato non ha iscritti al momento");
    		return;
    		
    	}else { 
    	
    		String info="";
    		
    		for(Studente s:iscritti) {
    			info+=s.toString();
    		}

    		txtResult.setText(info);
    		return;
    		
    	}
    	
    	
    }

    @FXML
    void doCercaNome(ActionEvent event) {
    	Integer matricola;
    	
    	try{ matricola=Integer.parseInt(txtMatricola.getText()) ;
    	
    	}catch(NumberFormatException nfe){
    		txtResult.setText("Ma che cazzo fai?");
    			return;
    	}
    	Studente studente= model.getStudente(matricola);
    	if(studente==null) {
    		txtResult.setText("Nessuno studente corrispondente trovato");
    		return;
    	}
    	
    	txtNome.setText(studente.getNome());
    	txtCognome.setText(studente.getCognome());
    	return;
    	

    }

    @FXML
    void doIscrivi(ActionEvent event) {
    	Integer matricola;
    	Corso corso;
    	

    	try{ matricola=Integer.parseInt(txtMatricola.getText()) ;
    	
    	}catch(NumberFormatException nfe){
    		txtResult.setText("Ma che cazzo fai?");
    			return;
    	}
    	Studente studente= model.getStudente(matricola);
    	if(studente==null) {
    		txtResult.setText("Nessuno studente corrispondente trovato");
    		return;
    	}
    	corso= model.getCorso(comboCorso.getValue());
    	
    	if(corso==null|| corso.getNome().equals("") ) {
    		txtResult.setText("Selezionare un corso!");
    	return;
    	}
    	
    	if(model.iscriviStudente(studente, corso)==false) {
    		txtResult.setText("Lo studente è gia' iscritto a questo corso.");
    	}else {
    		txtResult.setText("Lo studente "+studente.getNome()+ " "+studente.getCognome()+" e' stato iscritto al corso di  "+corso.getNome());
    	}
    	

    }

    @FXML
    void doReset(ActionEvent event) {
    	
    	txtResult.clear();
    	txtCognome.clear();
    	txtMatricola.clear();
    	txtNome.clear();

    }

    @FXML
    void initialize() {
    	
        assert comboCorso != null : "fx:id=\"comboCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaIscrittiCorso != null : "fx:id=\"btnCercaIscrittiCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCercaNome != null : "fx:id=\"btnCercaNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	
    	this.model=model;
    	ArrayList<Corso> corsi = model.getTuttiICorsi();
    	Corso vuoto=new Corso("");
    	corsi.add(0, vuoto);
    	comboCorso.getItems().addAll(corsi);
    }
}