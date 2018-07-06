package model;
//Team 1

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

	public ArrayList<Besucher> getBesucher() {
		return this.besuchern;
	}
	public void setBesuchern(ArrayList<Besucher> besuchern) {
		this.besuchern = besuchern;
	}

	public ArrayList<Vorstellung> getVorstellungen() {
		return this.vorstellungen;
	}
	public void setVorstellung(ArrayList<Vorstellung> vorstellungen) {
		this.vorstellungen = vorstellungen;
	}

	public Sammlung() {

	}

	public void addKinosaal(Kinosaal kinosaal){
		this.kinosaale.add(kinosaal);
	}
	public void removeKinosaal(Kinosaal kinosaal){
		this.kinosaale.remove(kinosaal);
	}

	public void addBesucher(Besucher besucher){
		this.besuchern.add(besucher);
	}
	public void removeBesucher(Besucher besucher){
		this.besuchern.remove(besucher);
	}

	public void addVorstellung(Vorstellung vorstellung){
		this.vorstellungen.add(vorstellung);
	}
	public void removeVorstellungen(Vorstellung vorstellung){
		this.vorstellungen.remove(vorstellung);
	}
}
