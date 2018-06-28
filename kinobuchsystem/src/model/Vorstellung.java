package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Vorstellung {

	private Kinosaal kinosaal;
	private Film film;
	private LocalDateTime time;
	private ArrayList<Reservierung> reservierungs = new ArrayList<>();

	public Kinosaal getKinosaal() {
		return this.kinosaal;
	}

	public void setKinosaal(Kinosaal kinosaal) {
		this.kinosaal = kinosaal;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public LocalDateTime getTime() {
		return this.time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Vorstellung() {

	}

	/**
	 * 
	 * @param kinosaal
	 * @param film
	 * @param time
	 */
	public Vorstellung(Kinosaal kinosaal, Film film, LocalDateTime time) {
		this.kinosaal = kinosaal;
		this.film = film;
		this.time = time;
	}
	public void AddReservierung(Reservierung reservierung){
		this.reservierungs.add(reservierung);
	}
	public void RemoveReservierung(Reservierung reservierung){
		if(this.reservierungs.contains(reservierung)){
			this.reservierungs.remove(reservierung);
		}
		else{
			System.out.println("Reservierung wurde nicht gefunden :,(");
		}
	}
	public ArrayList<Reservierung> GetReservierung(Besucher besucher){
		ArrayList<Reservierung> reservierungenVomBesucher = new ArrayList<>();
		for(Reservierung bestehendeReservierung : this.reservierungs){
			if(bestehendeReservierung.getBesucher() == besucher){
				reservierungenVomBesucher.add(bestehendeReservierung);
			}
		}
		if(reservierungenVomBesucher.size() == 0){
			System.out.println("Keine Reservierungen wurden gefunden für diesen User xO");
		}
		return reservierungenVomBesucher;
	}
	public boolean IsReserviert(Platz platz){
		for(Reihe reihe : this.kinosaal.getReihen()){
			for(Platz kinosaalPlatz : reihe.getPlaetze()){
				if(kinosaalPlatz.getPlatzId() == platz.getPlatzId()){
					return true;
				}
			}
		}
		return false;
	}
	/**
	 *
	 * @param platz
	 */
	//todo: Methode erstellen
	/*public boolean isNextPlatzFree(Platz platz, Vorstellung vorstellung) {

	}*/
}