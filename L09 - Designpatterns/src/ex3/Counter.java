package ex3;

public enum Counter {
    COUNTER;

    // Counter value
    private int value = 0;

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
