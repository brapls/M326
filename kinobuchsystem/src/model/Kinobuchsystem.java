package model;
//Team 2

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Kinobuchsystem {

	private Sammlung sammlung;

	public Sammlung getSammlung() {
		return this.sammlung;
	}

	public void setSammlung(Sammlung sammlung) {
		this.sammlung = sammlung;
	}

	/**
	 *
	 * @param reservierung
	 */
	public void reservierungSpeichern(Reservierung reservierung) {
		sammlung.addBesucher(reservierung.getBesucher());

	}

	/**
	 *
	 * @param besucher
	 */
	public void registerBesucher(Besucher besucher) {
		sammlung.addBesucher(besucher);
	}

	public static void main(String[] args){
		Sammlung sammlung = new Sammlung();

		Kinosaal k = new Kinosaal();
		for (int i = 0; i < 10; i++){
			Reihe reihe = new Reihe();
			for (int y = 0; y < 10; y++){
				Platz p = new Platz();
				p.setPlatzId(y);
				reihe.add(p);
			}
			k.add(reihe);
		}

		Film f = new Film();
		f.setId(1);
		f.setTitel("Titel 1");
		f.setDauer("60 min");
		Vorstellung v = new Vorstellung();
		v.setFilm(f);
		v.setTime(LocalDateTime.now());
		v.setKinosaal(k);
		sammlung.addVorstellung(v);

		Kinosaal k2 = new Kinosaal();
		for (int i = 0; i < 5; i++){
			Reihe reihe = new Reihe();
			for (int y = 0; y < 5; y++){
				Platz p = new Platz();
				p.setPlatzId(y);
				reihe.add(p);
			}
			k2.add(reihe);
		}

		Film f2 = new Film();
		f2.setId(2);
		f2.setTitel("Titel 2");
		f2.setDauer("60 min");
		Vorstellung v2 = new Vorstellung();
		v2.setFilm(f2);
		v2.setTime(LocalDateTime.of(1990, 2,2,3,4));
		v2.setKinosaal(k2);
		sammlung.addVorstellung(v2);

		ArrayList<Vorstellung> vorstellungs = sammlung.getVorstellungen();
		for (Vorstellung vorstellung : vorstellungs) {
			System.out.println(vorstellungs.indexOf(vorstellung) + " " + v.getFilm().getTitel() + " " + v.getTime());
		}
		System.out.println("Vorstellung auswählen");
		Integer chosenVorstellung = readLineInt();
		try {
			Vorstellung vorsetellung = vorstellungs.get(chosenVorstellung);
			System.out.println("Sitzplatz auswählen");
			Kinosaal kinosaal = vorsetellung.getKinosaal();
			ArrayList<Reihe> reihen = kinosaal.getReihen();
			for (Reihe r : reihen) {
				for (Platz p : r.getPlaetze()) {
				    // Check if the place is already booked

					System.out.println("Reihe id : " + reihen.indexOf(r) + " Platz id : " + p.getPlatzId());
				}
			}
			System.out.println("Anzahl Plätze eingeben");
			Integer anzPlaetze = readLineInt();

			for (int i = 0; i < anzPlaetze; i++){
                System.out.println("Geben Sie bitte den Reihe und Platz id");
                String value = readLineString();
                value = value.replace(" ", "");
                Integer iReihe = Integer.parseInt(String.valueOf(value.charAt(0)));
                Integer iPlatz = Integer.parseInt(String.valueOf(value.charAt(1)));
                Platz platz = reihen.get(iReihe).getPlaetze().get(iPlatz);
                if(platz != null){
                    Reservierung reservierung = new Reservierung();
                    reservierung.setPlatz(platz);
                    reservierung.setBesucher(new Besucher());
                    System.out.println("Reservierung für platz " + platz.getPlatzId() + " wurde gespeichert.");
                } else {
                    System.out.println("Falsch");
                }
                System.out.println();
            }
		}
		catch (Exception ex){
			System.out.println("Diese vorstellung ist nicht definiert.");
		}
	}

	public static String readLineString() {
		String input = null;
		Scanner scanner = new Scanner(System.in);
		input = scanner.nextLine();
		return input;
	}

	public static Integer readLineInt() {
		try {
			String toConvert = readLineString();
			Integer converted = Integer.valueOf(toConvert);
			return converted;
		} catch (Exception e) {
			System.out.println("Your value was not a number");
			return 0;
		}
	}
}
