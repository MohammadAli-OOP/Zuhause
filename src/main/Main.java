package main;

import gui.BuergeraemterAnwendersystem;
import gui.TeeControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		new TeeControl(primaryStage);
	}	
	
	public static void main(String[] args){
		launch(args);
	}
}
