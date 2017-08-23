package ionel.exemplu1;

import java.util.Scanner;

public class Exemplu2 {

    public static void main(String[] args) {

        int a;
        int b;

        double d =3;



        Scanner sc = new Scanner(System.in);

        System.out.println("introduceti a:");
        a = sc.nextInt();

        System.out.println("introduceti b:");
        b = sc.nextInt();

        int maxim;

        if (a < b) // daca conditia e adevarata se executa ce e mai jos
        {
            maxim = b;


        } else // altfel adica daca e falsa se executa ce e mai jos
        {
            maxim = a;
        }

        System.out.println("Maximul este:"+maxim);

    }
}
