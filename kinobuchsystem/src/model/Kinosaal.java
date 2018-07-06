package model;
//Team 1

import java.util.ArrayList;

public class Kinosaal {

	private ArrayList<Reihe> reihen;

	public ArrayList<Reihe> getReihen() {
		return this.reihen;
	}

	public void setReihen(ArrayList<Reihe> reihen) {
		this.reihen = reihen;
	}

	public Kinosaal() {

	}

	/**
	 * 
	 * @param reihen
	 */
	public Kinosaal(ArrayList<Reihe> reihen) {
		this.reihen = reihen;
	}

	/**
	 * 
	 * @param reihe
	 */
	public void add(Reihe reihe) {
		this.reihen.add(reihe);
	}
}