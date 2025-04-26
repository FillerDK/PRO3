package ex3;

public class App {
    public static void main(String[] args) {
        // Access the singleton instance
        Counter counter1 = Counter.COUNTER;

        // Use the singleton instance
        counter1.count();
        System.out.println("Counter value after count: " + counter1.getValue());

        counter1.times2();
        System.out.println("Counter value after times2: " + counter1.getValue());

        counter1.zero();
        System.out.println("Counter value after zero: " + counter1.getValue());

        // Access the singleton instance again
        Counter counter2 = Counter.COUNTER;

        // Use the singleton instance again
        counter2.count();
        System.out.println("Counter value after count: " + counter2.getValue());
    }

}
