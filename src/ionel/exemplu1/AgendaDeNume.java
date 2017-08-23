package ionel.exemplu1;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AgendaDeNume {

    static Persoana[] agenda= new Persoana[5];
    static int pozitie=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int optiune = 0;
        do {
            System.out.println("1 - adaugare");
            System.out.println("2 - stergere");
            System.out.println("3 - afisare");
            System.out.println("4 - exit");


            optiune = sc.nextInt();

            if (optiune == 1)
                adaugare();
            else if (optiune == 2)
                stergere();
            else if (optiune == 3)
                afisare();

        }
        while (optiune != 4);

    }

    public static void afisare() {
        System.out.println("Continut agenda mea:");

        List myList = new ArrayList<Persoana>();
        try {
            myList= DemoDB.demoRead(); // apel db
            for(int i=0;i<myList.size();i++) { // iteratie , parcurgere
                Persoana p = (Persoana)myList.get(i);
                System.out.println(p.nume+":"+p.telefon);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void adaugare() {

        String n,t;
        Scanner sc = new Scanner(System.in);
        System.out.println("numele persoanei:");
        n=sc.nextLine();
        System.out.println("telefonul persoanei:");
        t=sc.nextLine();

        Persoana p = new Persoana(); // se naster persoana
        p.nume=n;
        p.telefon=t;
        try {
            DemoDB.demoCreate(p.nume, p.telefon);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void stergere() {

        // citesc un nume
        // il caut in agenda
        // daca exista pe pozitia lui pun ""
        long id;
        System.out.println("pe cine stergi? ");
        Scanner sc = new Scanner(System.in);
        id=sc.nextLong();
        try {
            DemoDB.demoDelete(id);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


//        agenda[0]="ionel";
//        agenda[1]="larisa";
//        agenda[2]="eunice";
//
//        for(int i=0;i<agenda.length;i++) {
//            if(agenda[i]!=null)
//             System.out.println(agenda[i]);
//        }

}
