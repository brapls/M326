import model.Sammlung;
import model.Vorstellung;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
      Sammlung sammlung = new Sammlung();
        System.out.println("1. Filme abrufen");
        System.out.println("2. Reservieren");
        System.out.println("3. Reservierung löschen");
        String value = readLineString();
        Integer val;
        try{
          Integer val = (Integer) value;
        }catch (Exception e) {
          Integer val = 0;
        }

        switch(val){
          case 1:
            ArrayList<Vorstellung> vorstellungen = sammlung.getVorstellungen();
            break;
          case 2:
            break;
        }
    }

    private static String readLineString(){
      Strin input = null;
      Scanner scanner = new Scanner(System.in);
      input = scanner.nextLine();
      return input;
    }
}
