package gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import business.Tee;
import business.TeeModel;
import javafx.stage.Stage;

public class TeeControl {
	private TeeModel teeModel;
	private TeeView teeView;
	
	public TeeControl(Stage primaryStage) {
		super();
		this.teeModel=new TeeModel();
		this.teeView=new TeeView(this, teeModel, primaryStage);
		
	}
    public void nehmeTeeAuf(){
    	try{
    		teeModel.setTee( new Tee(
        			this.teeView.getTxtArtikelnummer().getText(), 
       	            Float.parseFloat(this.teeView.getTxtBezeichnung().getText()),
       	            Float.parseFloat(this.teeView.getTxtKategorie().getText()),
       	         this.teeView.getTxtKoffin().getText(),
       	         this.teeView.getTxtKrauter().getText().split(";")));
    		this.teeView.zeigeInformationsfensterAn("Der Tee wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		this.teeView.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
    
    public void leseAusDatei(String typ){
    	try {
      		this.teeModel.leseAusDatei(typ);
      	}
		catch(IOException exc){
			this.teeView.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			this.teeView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!"+ exc.getMessage());
	        //exc.printStackTrace();  // Detaillierte Ausgabe des Fehlers in der Konsole
		}
	}
	public void schreibeTeeInCsvDatei() {
		try {
			this.teeModel.schreibeTeeInCsvDatei();
   			this.teeView.zeigeInformationsfensterAn(
	   			"Die Tee wurden gespeichert!");
		}	
		catch(IOException exc){
			this.teeView.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			this.teeView.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}
	
	
}
