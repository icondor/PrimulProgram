package ionel.exemplu1;

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
        for(int i=0;i<agenda.length;i++) {
             if(agenda[i]!=null) {
                 Persoana p = agenda[i]; // iau din agenda si pun in p
                 System.out.println(p.nume+":"+p.telefon);
             }

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
        agenda[pozitie]=p; // pun persoana in agenda
        pozitie++;
    }

    public static void stergere() {

        // citesc un nume
        // il caut in agenda
        // daca exista pe pozitia lui pun ""
        String nume;
        System.out.println("pe cine stergi? ");
        Scanner sc = new Scanner(System.in);
        nume=sc.nextLine();

        for(int i=0;i<agenda.length;i++) {
            if(agenda[i]!=null)
            if(nume.equals(agenda[i].nume)) {
               agenda[i]=null;
                System.out.println("am sters-o");
            }

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
