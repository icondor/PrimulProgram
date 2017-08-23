package ionel.exemplu1;

import java.util.Scanner;

public class DemoFor {

    public static void main(String[] args) {

//        for(int i=1; i<=10; i++) {
//            System.out.println("ana are mere");
//        }


        // afiseaza numerele de la 1 la 10
        for(int i=1; i<=10; i++) {

              System.out.println(i);
        }

        int i=0;
        while(i<=10) {
            System.out.println(i);
            i=i+1;
        }

        int a;
        Scanner sc = new Scanner(System.in);
        System.out.println("dati un numar:");
        a = sc.nextInt();
        while(a!=0) {
            System.out.println("dati un nou numar:");
            a = sc.nextInt();
        }
        System.out.println("gata");


    }
}
