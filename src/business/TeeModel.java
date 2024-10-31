package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TeeModel {
	private Tee tee;

	public Tee getTee() {
		return tee;
	}

	public void setTee(Tee tee) {
		this.tee = tee;
	}

	public void schreibeTeeInCsvDatei() throws IOException {
		
			BufferedWriter aus 
				= new BufferedWriter(new FileWriter("TeeAusgabe.csv", true));
			aus.write(tee.gibTeeZurueck(';'));
			aus.close();

		
		
	}
	
	public void leseAusDatei(String typ) throws IOException{

      		if("csv".equals(typ)){
      			BufferedReader ein = new BufferedReader(new FileReader("Tee.csv"));
      			String[] zeile = ein.readLine().split(";");
      			this.tee = new Tee(zeile[0], 
      				Float.parseFloat(zeile[1]), 
      				Float.parseFloat(zeile[2]), 
      				zeile[3], zeile[4].split("_"));
      				ein.close();
     
      		
      		}		
      }		
}
