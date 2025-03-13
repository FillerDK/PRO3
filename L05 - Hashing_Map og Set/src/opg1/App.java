package opg1;

import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        HashSet<Bil> biler = new HashSet();

        Bil nissan = new Bil("AA92471", "Nissan", "180SX", "Blå");
        Bil bmw1 = new Bil("BB85725", "BMW", "M5", "Hvid");
        Bil bmw2 = new Bil("BB85725", "BMW", "M5", "Hvid");
        Bil honda = new Bil("CC48537", "Honda", "Civic", "Sort");

        biler.add(nissan);
        biler.add(bmw1);
        biler.add(bmw2);
        biler.add(honda);

        System.out.println(biler.size());
    }
}
