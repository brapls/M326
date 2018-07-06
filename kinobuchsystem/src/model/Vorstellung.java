package model;
//Team 1

import javafx.print.PageLayout;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Vorstellung {

	private Kinosaal kinosaal;
	private Film film;
	private LocalDateTime time;
	private ArrayList<Reservierung> reservationen = new ArrayList<>();

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
		this.reservationen.add(reservierung);
	}
	public void RemoveReservierung(Reservierung reservierung){
		if(this.reservationen.contains(reservierung)){
			this.reservationen.remove(reservierung);
		}
		else{
			System.out.println("Reservierung wurde nicht gefunden :,(");
		}
	}
	public ArrayList<Reservierung> GetReservierung(Besucher besucher){
		ArrayList<Reservierung> reservierungenVomBesucher = new ArrayList<>();
		for(Reservierung bestehendeReservierung : this.reservationen){
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
	public boolean isNextPlatzFree(Platz platz, Vorstellung vorstellung) {
		Reihe zuBesetztendeReihe = null;
		int zuBesetztendePosition = -1;
		for(Reihe reihe : vorstellung.kinosaal.getReihen()){
			for(Platz kinosaalPlatz : reihe.getPlaetze()){
				if(kinosaalPlatz.getPlatzId() == platz.getPlatzId()){
					zuBesetztendeReihe = reihe;
					zuBesetztendePosition = reihe.getPlaetze().indexOf(platz);
				}
			}
		}
		//Reihe nicht gefunden
		if(zuBesetztendeReihe == null || zuBesetztendePosition == -1){
			return false;
		}
		else{
			try {
				//vorheriger Platz ist frei
				if (IsReserviert(zuBesetztendeReihe.getPlaetze().get(zuBesetztendePosition - 1))) {
					return true;
				}
			}
			catch (Exception ex){

			}
			try {
				//nächste Platz ist frei
				if (IsReserviert(zuBesetztendeReihe.getPlaetze().get(zuBesetztendePosition + 1))) {
					return true;
				}
			}//letzes Element rührt einen Fehler raus
			catch (Exception ex){}
			//kein Platz ist näbendran frei
			return false;
		}
	}

}