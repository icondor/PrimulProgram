package ionel.exemplu1;

public class Exemplu4 {

    public static void main(String[] args) {


        int[] sir = {10, 4, 6, 8, 12, 22, 11, 0, 5, 4}; // sir de intregi

//      larisa(sir);
//
//        int[] brrrr = {130, 4, 6, 8, 12, 22, 11, 10, 35, 43}; // sir de intregi
//
//      larisa(brrrr);

        int[] noulSir={2,3,4,6};
      ana(noulSir);

    }

    public static void larisa(int[] sir) {
        int max=sir[0];
        int min = sir[0];
        for (int i = 1; i < sir.length; i++) {

            if (sir[i] > max) {
                max = sir[i];
            }

            if (sir[i] < min) {
                min = sir[i];
            }

        }
        System.out.println("max este:"+max);
        System.out.println("min este:"+min);
    }

    public static void ana(int[] sir) {
     int pozitie=-1;
        for (int matei = 1; matei < sir.length; matei++) {

            if (sir[matei] ==22) {
               pozitie=matei;
            }

        }
        System.out.println(pozitie);

    }


}
