package factory;

import model.Platz;
/**
 * Created by Dominik on 10.07.18.
 */
public class platzFactory {

    int id =0;
    private static platzFactory instance;

    public static platzFactory getInstance(){
        if (instance==null){
            instance= new platzFactory();
        }
        return instance;
    }

    public Platz makePlatz(int id) {
        Platz p = new Platz();
        p.setPlatzId(id);
        return p;
    }


}
