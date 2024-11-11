package factory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConcreteProductA extends Product {
	private BufferedReader br;
	
	
	
	public ConcreteProductA() throws IOException {
		super();
		this.br = new BufferedReader(new FileReader("TeeAusgabe.csv"));
		
	}
	
	@Override
	public String[] leseAusDatei() throws IOException {
		
		String [] ergebnisZeile=new String[1];
		String zeile=br.readLine();
		int i=0;
		
//		int b=0;
//		while((zeile)!=null) {
//			zeile=br.readLine();
//			b++;
//		}
//		System.out.println(b);
		while(i<ergebnisZeile.length) {
			ergebnisZeile[i]=zeile;
			System.out.println(zeile);
			zeile=br.readLine();
			i++;
		}
		String [] array=ergebnisZeile[0].split(";");
		
		return ergebnisZeile[0].split(";");
	}

	@Override
	public void schliesseDatei() throws IOException {
		br.close();
		
	} 
	
}
