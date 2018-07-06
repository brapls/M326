package model;
//Team 1

import java.util.ArrayList;

public class Reihe {

	private Integer id;
	private ArrayList<Platz> plaetze;

	public ArrayList<Platz> getPlaetze() {
		return this.plaetze;
	}

	public void setPlaetze(ArrayList<Platz> plaetze) {
		this.plaetze = plaetze;
	}

	/**
	 * 
	 * @param platz
	 */
	public void add(Platz platz) {
		this.plaetze.add(platz);
	}



}