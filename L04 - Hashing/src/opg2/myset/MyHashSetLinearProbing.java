package opg2.myset;

/**
 * This class implements a hash set using separate chaining.
 */
public class MyHashSetLinearProbing<E> implements MySet<E> {
    private E[] table;
    private int size;

    private final E DELETED = (E)new Object();

    /**
     * Constructs a hash table.
     *
     * @param bucketsLength the length of the buckets array
     */
    public MyHashSetLinearProbing(int bucketsLength) {
        table = (E[]) new Object[bucketsLength];
        size = 0;
    }

    private int hash(int hashCode) {
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        return hashCode % table.length;
    }

    @Override
    /** Return true if the element is in the set */
    public boolean contains(E e) {
        int bucketIndex = hash(e.hashCode());
        E current = table[bucketIndex % table.length];
        boolean found = false;
        while (!found && current != null) {
            if (e.equals(current)) {
                found = true;
                // Is in the set
            } else {
                bucketIndex++;
                current = table[bucketIndex % table.length];
            }
        }
        return found;
    }

    @Override
    /** Remove all elements from this set */
    public void clear() {
        table = (E[]) new Object[table.length];
        size = 0;
    }

    /**
     * Add an element to the set.
     *
     * @return true if e is a new object, false if e was already in the set
     */
    public boolean add(E e) {
        int bucketIndex = hash(e.hashCode());
        E current = table[bucketIndex % table.length];
        boolean found = false;
        while (!found && current != null || current == DELETED) {
            if (current.equals(e)) {
                found = true;
                // Already in the set
            } else {
                bucketIndex++;
                current = table[bucketIndex % table.length];
            }
        }
        if (!found) {
            table[bucketIndex % table.length] = e;
            size++;
            double loadFactor = (double) (size) / table.length;
            if (loadFactor > 0.75) {
                reHash();
            }
        }
        return !found;
    }

    public void reHash() {
        E[] temp = table;

        table = (E[]) new Object[table.length*2 + 1];
        size = 0;

        for (E e : temp) {
            if (e != null && !e.equals(DELETED)) add(e);
        }
    }

    /**
     * Remove the element from the set.
     *
     * @return true if e was removed from this set, false if e was not an
     * element of this set
     */
    public boolean remove(E e) {
        int bucketIndex = hash(e.hashCode());
        E current = table[bucketIndex % table.length];
        boolean found = false;
        while (!found && current != null) {
            if (e.equals(current)) {
                found = true;
                // Is in the set
            } else {
                bucketIndex++;
                current = table[bucketIndex % table.length];
            }
        }
        if (found) {
            table[bucketIndex % table.length] = DELETED;
            size--;
        }
        return found;
    }

    @Override
    /** Return the number of elements in the set */
    public int size() {
        return size;
    }

    @Override
    /** Return true if the set contains no elements */
    public boolean isEmpty() {
        return size == 0;
    }


    // method only for test purpose
    public void writeOut() {
        for (int i = 0; i < table.length; i++) {
            E temp = table[i];
            if (temp != null) {
                System.out.println(i + "\t" + table[i]);
            }
        }
    }

}
