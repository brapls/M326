package model;
//Team 1

public class Film {

	private Integer id;
	private String titel;
	private String dauer;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitel() {
		return this.titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getDauer() {
		return this.dauer;
	}

	public void setDauer(String dauer) {
		this.dauer = dauer;
	}

	public Film() { }
	public Film(int id, String title, String dauer) {
		this.id = id;
		this.titel = title;
		this.dauer = dauer;
	}

}