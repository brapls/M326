package model;

import java.util.ArrayList;

public class Sammlung {

	private ArrayList<Kinosaal> kinosaale;
	private ArrayList<Besucher> besuchern;
	private ArrayList<Vorstellung> vorstellungen;
	private ArrayList<Reservierung> reservierungen;

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
		// TODO - implement model.Sammlung.model.Sammlung
		throw new UnsupportedOperationException();
	}

}