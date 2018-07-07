import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by brian on 06.07.2018.
 */
public class test {
    //Get and Set of the attributes in the class Besucher
    @Test
    public void testBesucher(){
        Besucher besucher = new Besucher("Telefonnummer", "Vorname", "Nachname");
        Assertions.assertEquals("Telefonnummer", besucher.getTelefonnummer());
        Assertions.assertEquals("Vorname", besucher.getVorname());
        Assertions.assertEquals("Nachname", besucher.getNachname());
        besucher.setNachname("Nachname2");
        besucher.setVorname("Vorname2");
        besucher.setTelefonnummer("Telefonnummer2");
        Assertions.assertEquals("Telefonnummer2", besucher.getTelefonnummer());
        Assertions.assertEquals("Vorname2", besucher.getVorname());
        Assertions.assertEquals("Nachname2", besucher.getNachname());
    }
    //Get and Set of the attributes in the class Film
    @Test
    public void testFilm(){
    Film film = new Film(1, "Titel", "Dauer");
        Assertions.assertEquals( "1", film.getId().toString());
        Assertions.assertEquals("Titel", film.getTitel());
        Assertions.assertEquals("Dauer", film.getDauer());
    }
    //Get and Set of the attributes in the class Platz
    @Test
    public void testPlatz(){
        Platz platz = new Platz(1);
        Assertions.assertEquals("1", platz.getPlatzId().toString() );
        platz.setPlatzId(2);
        Assertions.assertEquals("2", platz.getPlatzId().toString());
    }
    //Get and Set of the attributes in the class Reihe
    @Test
    public void testReihe(){
        ArrayList<Platz> plaetze = new ArrayList<>();
        plaetze.add(new Platz(1));
        plaetze.add(new Platz(2));
        Reihe reihe = new Reihe(1, plaetze);
        Assertions.assertEquals("1", String.valueOf(reihe.getId()));
        Assertions.assertEquals("2", String.valueOf(reihe.getPlaetze().size()));
        plaetze.add(new Platz(3));
        reihe.setId(2);
        reihe.setPlaetze(plaetze);
        Assertions.assertEquals("2", String.valueOf(reihe.getId()));
        Assertions.assertEquals("3", String.valueOf(reihe.getPlaetze().size()));
    }
    //Get and Set of the attributes in the class Kinosaal
    @Test
    public void testKinosaal(){
        ArrayList<Platz> plaetze = new ArrayList<>();
        plaetze.add(new Platz(1));
        plaetze.add(new Platz(2));
        ArrayList <Reihe> reihen = new ArrayList<>();
        Reihe reihe = new Reihe(1, plaetze);
        reihen.add(reihe);
        Kinosaal kinosaal = new Kinosaal(reihen);
        Assertions.assertEquals("2", String.valueOf(kinosaal.getReihen().get(0).getPlaetze().get(1).getPlatzId()));
        kinosaal.setReihen(new ArrayList<Reihe>());
        Assertions.assertEquals(0, kinosaal.getReihen().size());
    }
    //Get and Set of the attributes in the class Reservierung
    @Test
    public void testReservierung(){
        Besucher besucher = new Besucher("Telefonnummer", "Vorname", "Nachname");
        Platz platz = new Platz(1);
        Reservierung reservierung = new Reservierung(platz, besucher);
        Assertions.assertEquals("1", reservierung.getPlatz().getPlatzId().toString());
        Assertions.assertEquals("Nachname", reservierung.getBesucher().getNachname());
        reservierung.setPlatz(new Platz(2));
        reservierung.setBesucher(new Besucher("Telefonnummer2", "Vorname2", "Nachname2"));
        Assertions.assertEquals("2", reservierung.getPlatz().getPlatzId().toString());
        Assertions.assertEquals("Nachname2", reservierung.getBesucher().getNachname());
    }
    //Get, Set, Add and Remove of the attributes in the class Sammlung
    @Test
    public void testSammlung(){
        //kinosaal1
        ArrayList<Platz> plaetze = new ArrayList<>();
        plaetze.add(new Platz(1));
        plaetze.add(new Platz(2));
        ArrayList <Reihe> reihen = new ArrayList<>();
        Reihe reihe = new Reihe(1, plaetze);
        reihen.add(reihe);
        Kinosaal kinosaal1 = new Kinosaal(reihen);

        //kinosaal2
        ArrayList<Platz> plaetze2 = new ArrayList<>();
        plaetze.add(new Platz(2));
        plaetze.add(new Platz(3));
        ArrayList <Reihe> reihen2 = new ArrayList<>();
        Reihe reihe2 = new Reihe(2, plaetze2);
        reihen.add(reihe2);
        Kinosaal kinosaal2 = new Kinosaal(reihen2);

        //Kinosaale
        ArrayList<Kinosaal> kinosaale = new ArrayList<Kinosaal>();
        kinosaale.add(kinosaal1);
        kinosaale.add(kinosaal2);

        //Besucher
        Besucher besucher1 = new Besucher("1","1","1");
        Besucher besucher2 = new Besucher("2","2","2");

        //Besucher list
        ArrayList<Besucher> besucherList =  new ArrayList<>();
        besucherList.add(besucher1);
        besucherList.add(besucher2);

        //Vorstellung
        Vorstellung vorstellung = new Vorstellung(kinosaal1, new Film(), LocalDateTime.MAX);
        Vorstellung vorstellung2 = new Vorstellung(kinosaal2, new Film(), LocalDateTime.MAX);

        //Vorstellungen
        ArrayList<Vorstellung> vorstellungen = new ArrayList<Vorstellung>();
        vorstellungen.add(vorstellung);
        vorstellungen.add(vorstellung2);

        //Sammlung values set
        Sammlung sammlung = new Sammlung();
        sammlung.setKinosaale(kinosaale);
        sammlung.setBesuchern(besucherList);
        sammlung.setVorstellung(vorstellungen);

        Assertions.assertEquals(2, sammlung.getKinosaale().size());
        Assertions.assertEquals(2, sammlung.getBesucher().size());
        Assertions.assertEquals(2, sammlung.getVorstellungen().size());

        sammlung.removeBesucher(besucher1);
        sammlung.removeKinosaal(kinosaal1);
        sammlung.removeVorstellungen(vorstellung);

        Assertions.assertEquals(1, sammlung.getKinosaale().size());
        Assertions.assertEquals(1, sammlung.getBesucher().size());
        Assertions.assertEquals(1, sammlung.getVorstellungen().size());

        sammlung.addBesucher(besucher1);
        sammlung.addVorstellung(vorstellung);
        sammlung.addKinosaal(kinosaal1);

        Assertions.assertEquals(2, sammlung.getKinosaale().size());
        Assertions.assertEquals(2, sammlung.getBesucher().size());
        Assertions.assertEquals(2, sammlung.getVorstellungen().size());
    }
}
