package business;

public class Tee {
	
	// artikelnummer des Teees
    private String artikelnummer;
    // Infos
    private float bezeichnung;
    private float kategorie;
    // KOffin des Teees
    private String koffin;
    // krauter des Tees
    private String[] krauter;

    public Tee(String artikelnummer, float bezeichnung, float kategorie,
    	String koffin, String[] krauter){
   		this.artikelnummer = artikelnummer;
  	    this.bezeichnung = bezeichnung;
   	    this.kategorie = kategorie;
   	    this.koffin = koffin;
   	    this.krauter = krauter;
    }
    
	public String getArtikelnummer() {
		return artikelnummer;
	}

	public void setartikelnummer(String artikelnummer) {
		this.artikelnummer = artikelnummer;
	}

	public float getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(float bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public float getKategorie() {
		return kategorie;
	}

	public void setKategorie(float kategorie) {
		this.kategorie = kategorie;
	}

	public String getKoffin() {
		return koffin;
	}

	public void setKoffin(String koffin) {
		this.koffin = koffin;
	}

	public String[] getKrauter() {
		return krauter;
	}

	public void setKrauter(String[] krauter) {
		this.krauter = krauter;
	}
	
	public String getkrauterAlsString(char trenner) {
		String ergebnis = "";
		int i = 0;
		for(i = 0; i < this.getKrauter().length - 1; i++) {
			ergebnis = ergebnis + this.getKrauter()[i] + trenner; 
		}
		return ergebnis	+ this.getKrauter()[i];
	}
	
	public String gibTeeZurueck(char trenner){
  		return this.getArtikelnummer() + trenner 
  			+ this.getBezeichnung() + trenner
  		    + this.getKategorie() + trenner
  		    + this.getKoffin() + trenner 
  		    + this.getkrauterAlsString(trenner) + "\n";
  	}
}

