package model;

import java.util.ArrayList;

public class Sammlung {

	private ArrayList<Kinosaal> kinosaale = new ArrayList<Kinosaal>();
	private ArrayList<Besucher> besuchern = new ArrayList<Besucher>();
	private ArrayList<Vorstellung> vorstellungen = new ArrayList<Vorstellung>();

	public ArrayList<Kinosaal> getKinosaale() {
		return this.kinosaale;
	}

	public void setKinosaale(ArrayList<Kinosaal> kinosaale) {
		this.kinosaale = kinosaale;
	}
	public ArrayList<Besucher> getBesuchern() {
		return this.besuchern;
	}

	public void setBesuchern(ArrayList<Besucher> besuchern) {
		this.besuchern = besuchern;
	}

	public Sammlung() {

	}

}