package model;
//Team 1

public class Reservierung {

	private Platz platz;
	private Besucher besucher;


	public Platz getPlatz() {
		return this.platz;
	}

	public void setPlatz(Platz platz) {
		this.platz = platz;
	}

	public Besucher getBesucher() {
		return this.besucher;
	}

	public void setBesucher(Besucher besucher) {
		this.besucher = besucher;
	}

	public Reservierung() {
	}

	/**
	 *
	 * @param platz
	 * @param besucher
	 */
	public Reservierung(Platz platz, Besucher besucher) {
		this.platz = platz;
		this.besucher = besucher;
	}

}