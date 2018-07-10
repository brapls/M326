package factory;

import model.Platz;
import model.Reihe;

import java.util.ArrayList;

/**
 * Created by Dominik on 10.07.18.
 */
public class reiheFactory {

    int id =0;
    private static reiheFactory instance;

    public static reiheFactory getInstance(){
        if (instance==null){
            instance= new reiheFactory();
        }
        return instance;
    }


    //Do not use this method, use the one Below
    public Reihe createReihe() {
        Reihe returnO = new Reihe(id, new ArrayList<>());
        returnO.add(new Platz(0));
        id++;
        return returnO;
    }


    public Reihe createReihe(int plaetze) {
        Reihe returnO = new Reihe(id, new ArrayList<>());
        id++;

        for (int i = 0; i<plaetze; i++){
            returnO.add(platzFactory.getInstance().makePlatz(i));
        }

        return returnO;
    }


    public void resetID(){id = 0;}

}
