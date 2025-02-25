package opgaver;

import java.util.Arrays;

public class Opg3 {
    /*
       Algoritme prefixAverage.

       Du skal lave en metode der givet et array af helttal
       beregner prefix gennemsnittet af tallene i arrayet.

       Prefix gennemsnittet af et array er et nyt array hvor
       indeks i indeholder gennemsnittet af tallene på
       indeksplads 0 til i, i det oprindelige array. Dette
       kan illustreres med nedenstående eksempel:

       Givet arrayet

       {5, 10, 5, 6, 4, 9, 8}

       Er prefixarrayet

       {5.0, 7.5, 6.667, 6.5, 6.0, 6.5, 6.714}

       Metoden har følgende signatur:

       public static double[] prefixAverage(int[] inputTal)

       Programmer metoden så den før den mindst mulige
       tidskompleksitet.
     */

    public static void main(String[] args) {
        int[] givetArray = {5, 10, 5, 6, 4, 9, 8};

        System.out.println(Arrays.toString(givetArray));
        System.out.println(Arrays.toString(prefixAverage(givetArray)));
    }

    public static double[] prefixAverage(int[] inputTal) {
        double[] output = new double[inputTal.length];
        int total = 0;

        for (int i = 0; i < inputTal.length; i++) {
            total += inputTal[i];
            double average = (total * 1.0) / (i+1);
            output[i] = average;
        }

        return output;
    }
}
