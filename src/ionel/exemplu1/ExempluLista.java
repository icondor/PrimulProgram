package ionel.exemplu1;

import java.util.ArrayList;
import java.util.List;

public class ExempluLista {

    public static void main(String[] args) {

        List listaDePersoane  = new ArrayList<Persoana>();
        listaDePersoane.add(new Persoana());
        listaDePersoane.add(6);
        listaDePersoane.add(7);

        for(int i=0;i<listaDePersoane.size();i++) {
            System.out.println(listaDePersoane.get(i));
        }

    }
}
