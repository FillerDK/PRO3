package ex2;

public class Counter {
    // Singleton instance
    private static Counter uniqueCounter = null;
    // Counter value
    private int value;

    // Singleton instance retrieval method
    public static Counter getUniqueCounter() {
        if (uniqueCounter == null) {
            uniqueCounter = new Counter();
        }
        return uniqueCounter;
    }

    // Private constructor to prevent instantiation
    private Counter() {
        value = 0;
    }

    // Methods to manipulate the counter value
    public void count() {
        value++;
    }

    // Method to multiply the counter value by 2
    public void times2() {
        value *= 2;
    }

    // Method to reset the counter value to 0
    public void zero() {
        value = 0;
    }

    // Method to get the current counter value
    public int getValue() {
        return value;
    }
}
