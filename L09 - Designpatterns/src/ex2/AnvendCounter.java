package ex2;

public class AnvendCounter {
    public static void main(String[] args) {
        // Create a Counter instance
        Counter counter = Counter.getUniqueCounter();

        // Use the Counter instance
        counter.count();
        System.out.println("Counter value after count: " + counter.getValue());

        counter.times2();
        System.out.println("Counter value after times2: " + counter.getValue());

        counter.zero();
        System.out.println("Counter value after zero: " + counter.getValue());
    }
}
