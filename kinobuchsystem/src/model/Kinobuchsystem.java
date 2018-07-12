package model;
//Team 2

import factory.movieFactory;
import factory.reiheFactory;

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

		// Erstellen der ersten Vorstellung
		Kinosaal Kinosaal1 = new Kinosaal();
		for (int i = 0; i < 10; i++){
			Reihe reihe = reiheFactory.getInstance().createReihe(10);
            Kinosaal1.add(reihe);
		}

		Film f = movieFactory.getInstance().createMovie("Iron Man 5","80 min");
		Vorstellung v = new Vorstellung();
		v.setFilm(f);
		v.setTime(LocalDateTime.of(2018, 6,9,17,15));
		v.setKinosaal(Kinosaal1);
		sammlung.addVorstellung(v);

		// Erstellen der zweiten Vorstellung
		Kinosaal Kinosaal2 = new Kinosaal();
		for (int i = 0; i < 5; i++) {
			Reihe reihe = reiheFactory.getInstance().createReihe(5);
            Kinosaal2.add(reihe);
		}

		Film f2 = movieFactory.getInstance().createMovie("Batman 8","60 min");
		Vorstellung v2 = new Vorstellung();
		v2.setFilm(f2);
		v2.setTime(LocalDateTime.of(1990, 2,2,3,4));
		v2.setKinosaal(Kinosaal2);
		sammlung.addVorstellung(v2);

		// Erstellen der dritten Vorstellung
		Kinosaal Kinosaal3 = new Kinosaal();
		for (int i = 0; i < 5; i++) {
			Reihe reihe = reiheFactory.getInstance().createReihe(8);
			Kinosaal3.add(reihe);
		}

		Film f3 = movieFactory.getInstance().createMovie("Avengers 42","120 min");
		Vorstellung v3 = new Vorstellung();
		v3.setFilm(f3);
		v3.setTime(LocalDateTime.of(2038, 5,6,20,15));
		v3.setKinosaal(Kinosaal3);
		sammlung.addVorstellung(v3);

		// Erstellen der vierten Vorstellung
		Kinosaal Kinosaal4 = new Kinosaal();
		for (int i = 0; i < 5; i++) {
			Reihe reihe = reiheFactory.getInstance().createReihe(6);
			Kinosaal4.add(reihe);
		}

		Film f4 = movieFactory.getInstance().createMovie("Avatar 2","100 min");
		Vorstellung v4 = new Vorstellung();
		v4.setFilm(f4);
		v4.setTime(LocalDateTime.of(2040, 4,12,20,00));
		v4.setKinosaal(Kinosaal4);
		sammlung.addVorstellung(v4);


		ArrayList<Vorstellung> vorstellungs = sammlung.getVorstellungen();
        System.out.println(
                "Id" +
                        "\t" +
                        "Filmtitel" +
                        "\t\t" +
                        "Zeitpunkt" +
                        "\t\t\t" +
                        "Dauer der Vorstellung" +
                        "\n" +
                        "-------------------------------------------------------------"
        );
		for (Vorstellung vorstellung : vorstellungs) {
            System.out.println(
                    vorstellungs.indexOf(vorstellung) +
                            "\t" +
                            vorstellung.getFilm().getTitel() +
                            "\t\t" +
                            vorstellung.getTime() +
                            "\t" +
                            vorstellung.getFilm().getDauer()
            );
        }

		System.out.println( "\n" + "Vorstellungs Id auswählen: ");
		Integer chosenVorstellung = readLineInt();
		try {
			Vorstellung vorsetellung = vorstellungs.get(chosenVorstellung);
			System.out.println("Sitzplatz auswählen: " + "\n");
			Kinosaal kinosaal = vorsetellung.getKinosaal();
			ArrayList<Reihe> reihen = kinosaal.getReihen();
			int x = 1;
			for (Reihe r : reihen) {
				System.out.println("Reihe " + x);
				System.out.println("----------------------------");
				x++;
				for (Platz p : r.getPlaetze()) {
				    // Check if the place is already booked

					System.out.println("Reihe Id : " + reihen.indexOf(r) + "\t" + "Platz Id : " + p.getPlatzId());
				}
				System.out.println("\n");
			}
			System.out.println("Anzahl Plätze eingeben: ");
			Integer anzPlaetze = readLineInt();

			for (int i = 0; i < anzPlaetze; i++){
                System.out.println("Geben Sie bitte den Reihe und Platz Id: ");
                String value = readLineString();
                value = value.replace(" ", "");
                Integer iReihe = Integer.parseInt(String.valueOf(value.charAt(0)));
                Integer iPlatz = Integer.parseInt(String.valueOf(value.charAt(1)));
                Platz platz = reihen.get(iReihe).getPlaetze().get(iPlatz);
                if(platz != null){
                    Reservierung reservierung = new Reservierung();
                    reservierung.setPlatz(platz);
                    reservierung.setBesucher(new Besucher());
                    System.out.println("Reservierung für Platz " + platz.getPlatzId() + " wurde gespeichert.");
                } else {
                    System.out.println("Falsch");
                }
                System.out.println();
            }
		}
		catch (Exception ex){
			System.out.println("Diese Vorstellung ist nicht definiert.");
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
