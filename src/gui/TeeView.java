package gui;

import business.TeeModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;



public class TeeView {
    //---Anfang Attribute der grafischen Oberflaeche---
    private Pane pane     					= new  Pane();
    private Label lblEingabe    	 		= new Label("Eingabe");
    private Label lblAnzeige   	 	    	= new Label("Anzeige");
    private Label lblArtikelnummer 					= new Label("Artikelnummer:");
    private Label lblBezeichnung   		= new Label("Bezeichnung:");
    private Label lblKategorie  	 		= new Label("Kategorie :");
    private Label lblKoffin   			= new Label("Koffin:");
    private Label lblKrauter  		= new Label("Krauter:");

	private TextField txtArtikelnummer 	 			= new TextField();
    private TextField txtBezeichnung		= new TextField();
    private TextField txtKategorie		= new TextField();
    private TextField txtKoffin			= new TextField();
    private TextField txtKrauter	= new TextField();
    private TextArea txtAnzeige  			= new TextArea();
    private Button btnEingabe 		 		= new Button("Eingabe");
    private Button btnAnzeige 		 		= new Button("Anzeige");
    private MenuBar mnbrMenuLeiste  		= new MenuBar();
    private Menu mnDatei             		= new Menu("Datei");
    private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
    private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
    private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");
	
	private TeeControl teeControl;
	private TeeModel teeModel;
	public TeeView(TeeControl teeControl, TeeModel teeModel, Stage primaryStage) {
		super();
		this.teeControl = teeControl;
		this.teeModel = teeModel;
		Scene scene = new Scene(this.pane, 700, 340);
    	primaryStage.setScene(scene);
    	primaryStage.setTitle("Verwaltung von Tee");
    	primaryStage.show();
    	this.initKomponenten();
		this.initListener();
		
	}
    private void initKomponenten(){
       	// Labels
    	lblEingabe.setLayoutX(20);
    	lblEingabe.setLayoutY(40);
    	Font font = new Font("Arial", 24); 
    	lblEingabe.setFont(font);
    	lblEingabe.setStyle("-fx-font-weight: bold;"); 
    	lblAnzeige.setLayoutX(400);
    	lblAnzeige.setLayoutY(40);
      	lblAnzeige.setFont(font);
       	lblAnzeige.setStyle("-fx-font-weight: bold;"); 
       	lblArtikelnummer.setLayoutX(20);
    	lblArtikelnummer.setLayoutY(90);
    	lblBezeichnung.setLayoutX(20);
    	lblBezeichnung.setLayoutY(130);
    	lblKategorie.setLayoutX(20);
    	lblKategorie.setLayoutY(170);
    	lblKoffin.setLayoutX(20);
    	lblKoffin.setLayoutY(210);
    	lblKrauter.setLayoutX(20);
    	lblKrauter.setLayoutY(250);    	
       	pane.getChildren().addAll(lblEingabe, lblAnzeige, 
       		lblArtikelnummer, lblBezeichnung, lblKategorie,
       		lblKoffin, lblKrauter);
    
    	// Textfelder
     	txtArtikelnummer.setLayoutX(170);
    	txtArtikelnummer.setLayoutY(90);
    	txtArtikelnummer.setPrefWidth(200);
    	txtBezeichnung.setLayoutX(170);
    	txtBezeichnung.setLayoutY(130);
    	txtBezeichnung.setPrefWidth(200);
    	txtKategorie.setLayoutX(170);
    	txtKategorie.setLayoutY(170);
    	txtKategorie.setPrefWidth(200);
      	txtKoffin.setLayoutX(170);
    	txtKoffin.setLayoutY(210);
    	txtKoffin.setPrefWidth(200);
    	txtKrauter.setLayoutX(170);
    	txtKrauter.setLayoutY(250);
    	txtKrauter.setPrefWidth(200);
      	pane.getChildren().addAll( 
     		txtArtikelnummer, txtBezeichnung, txtKategorie,
     		txtKoffin, txtKrauter);
     	
        // Textbereich	
        txtAnzeige.setEditable(false);
     	txtAnzeige.setLayoutX(400);
    	txtAnzeige.setLayoutY(90);
     	txtAnzeige.setPrefWidth(270);
    	txtAnzeige.setPrefHeight(185);
       	pane.getChildren().add(txtAnzeige); 
       	
        // Buttons
        btnEingabe.setLayoutX(20);
        btnEingabe.setLayoutY(290);
        btnAnzeige.setLayoutX(400);
        btnAnzeige.setLayoutY(290);
        pane.getChildren().addAll(btnEingabe, btnAnzeige); 
        
 		// Menue
  	    this.mnbrMenuLeiste.getMenus().add(mnDatei);
  	    this.mnDatei.getItems().add(mnItmCsvImport);
  	    this.mnDatei.getItems().add(mnItmTxtImport);
  	    this.mnDatei.getItems().add(new SeparatorMenuItem());
  	    this.mnDatei.getItems().add(mnItmCsvExport);
 	    pane.getChildren().add(mnbrMenuLeiste);
   }
   
   private void initListener() {
	    btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
            	teeControl.nehmeTeeAuf();
            }
            
	    });
	    btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	            zeigeBuergeraemterAn();
	        } 
   	    });
	    mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
	    	@Override
	        public void handle(ActionEvent e) {
	    		teeControl.leseAusDatei("csv");
	    	}
	    });
	    mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent e) {
		    	teeControl.leseAusDatei("txt");
		    }
    	});
	    mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				teeControl.schreibeTeeInCsvDatei();
			}	
	    });
    }
   
   
   private void zeigeBuergeraemterAn(){
   	if(this.teeModel.getTee() != null){
   		txtAnzeige.setText(
   			this.teeModel.getTee().gibTeeZurueck(' '));
   	}
   	else{
   		zeigeInformationsfensterAn("Bisher wurde kein Tee aufgenommen!");
   	}
   }
   

  void zeigeInformationsfensterAn(String meldung){
   	new MeldungsfensterAnzeiger(AlertType.INFORMATION,
   		"Information", meldung).zeigeMeldungsfensterAn();
   }	
   
   void zeigeFehlermeldungsfensterAn(String meldung){
      	new MeldungsfensterAnzeiger(AlertType.ERROR,
       	"Fehler", meldung).zeigeMeldungsfensterAn();
   }
	
   public TextField getTxtArtikelnummer() {
		return txtArtikelnummer;
	}
	public void setTxtArtikelnummer(TextField txtArtikelnummer) {
		this.txtArtikelnummer = txtArtikelnummer;
	}
	public TextField getTxtBezeichnung() {
		return txtBezeichnung;
	}
	public void setTxtBezeichnung(TextField txtBezeichnung) {
		this.txtBezeichnung = txtBezeichnung;
	}
	public TextField getTxtKategorie() {
		return txtKategorie;
	}
	public void setTxtKategorie(TextField txtKategorie) {
		this.txtKategorie = txtKategorie;
	}
	public TextField getTxtKoffin() {
		return txtKoffin;
	}
	public void setTxtKoffin(TextField txtKoffin) {
		this.txtKoffin = txtKoffin;
	}
	public TextField getTxtKrauter() {
		return txtKrauter;
	}
	public void setTxtKrauter(TextField txtKrauter) {
		this.txtKrauter = txtKrauter;
	}
	public TextArea getTxtAnzeige() {
		return txtAnzeige;
	}
	public void setTxtAnzeige(TextArea txtAnzeige) {
		this.txtAnzeige = txtAnzeige;
	}

	
}
