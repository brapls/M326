package factory;

import model.Film;
/**
 * Created by Dominik on 10.07.18.
 */
public class movieFactory {


    int filmID;


    private movieFactory(){
        filmID=0;
    };

    private static movieFactory instance;

    public static movieFactory getInstance(){
        if (instance==null){
            instance= new movieFactory();
        }
        return instance;
    }


    public Film createMovie(String title){
        Film returnObject = new Film();
        returnObject.setTitel(title);
        returnObject.setDauer("0");
        returnObject.setId(filmID);
        filmID++;
        return returnObject;
    }


    public Film createMovie(String title, String dauer){
        Film returnObject = new Film();
        returnObject.setTitel(title);
        returnObject.setDauer(dauer);
        returnObject.setId(filmID);
        filmID++;
        return returnObject;
    }


}
