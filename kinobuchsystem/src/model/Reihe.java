package model;
//Team 1

import java.util.ArrayList;

public class Reihe {

	private Integer id;
	private ArrayList<Platz> plaetze;


	public Reihe(){
		id = 0;
		plaetze = new ArrayList<>();
	}
	public Reihe(int id, ArrayList<Platz> plaetze){
		this.id = id;
		this.plaetze = plaetze;
	}
	public ArrayList<Platz> getPlaetze() {
		return this.plaetze;
	}

	public void setPlaetze(ArrayList<Platz> plaetze) {
		this.plaetze = plaetze;
	}

	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	/**
	 *
	 * @param platz
	 */
	public void add(Platz platz) {
		this.plaetze.add(platz);
	}



}
