package model;
//Team 1

public class Platz {

	private Integer platzId;

	public Integer getPlatzId() {
		return this.platzId;
	}

	public void setPlatzId(int platzId) {
		this.platzId = platzId;
	}

	public Platz() {
		this.platzId = 0;
	}
	/**
	 *
	 * @param platzId
	 */
	public Platz(int platzId) {
		this.platzId = platzId;
	}

}
