package model;
//Team 1

import java.util.ArrayList;

public class Besucher {
	private String telefonnummer;
	private String vorname;
	private String nachname;

	public Besucher() { }
    public Besucher(String telefonnummer, String vorname, String nachname) {
	    this.telefonnummer = telefonnummer;
	    this.vorname = vorname;
	    this.nachname = nachname;
    }
    public String getVorname(){
	    return this.vorname;
    }
    public void setVorname(String vorname){
        this.vorname = vorname;
    }
    public String getTelefonnummer(){
        return this.telefonnummer;
    }
    public void setTelefonnummer(String telefonnummer){
        this.vorname = telefonnummer;
    }
    public String getNachname(){
        return this.nachname;
    }
    public void setNachname(String nachname){
        this.vorname = nachname;
    }
}