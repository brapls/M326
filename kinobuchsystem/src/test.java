import model.Besucher;
import model.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created by brian on 06.07.2018.
 */
public class test {
    @Test
    public void testBesucher(){
        Besucher besucher = new Besucher("Telefonnummer", "Vorname", "Nachname");
        Assertions.assertEquals(besucher.getTelefonnummer(), "Telefonnummer");
        Assertions.assertEquals(besucher.getVorname(), "Vorname");
        Assertions.assertEquals(besucher.getNachname(), "Nachname");
        besucher.setNachname("Nachname2");
        besucher.setVorname("Vorname2");
        besucher.setTelefonnummer("Telefonnummer2");
        Assertions.assertEquals(besucher.getTelefonnummer(), "Telefonnummer2");
        Assertions.assertEquals(besucher.getVorname(), "Vorname2");
        Assertions.assertEquals(besucher.getNachname(), "Nachname2");
    }
    @Test
    public void testFilm(){
    Film film = new Film(1, "Titel", "Dauer");
        Assertions.assertEquals(film.getId().toString(), "1");
        Assertions.assertEquals(film.getTitel(), "Titel");
        Assertions.assertEquals(film.getDauer(), "Dauer");
    }
}
