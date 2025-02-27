package opg2.myset;

import java.util.ArrayList;
import java.util.List;

public class MyHashSetChaining<E> implements MySet<E> {
    // The number of elements in the set
    private int size = 0;

    // Hash table is an array with each cell that is a linked list
    private Node<E>[] table;

    public MyHashSetChaining(int bucketsLength) {
        table = (Node<E>[])new Node[bucketsLength];
        size = 0;
    }

    /** Hash function */
    private int hash(int hashCode) {
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        return hashCode % table.length;
    }

    @Override /** Remove all elements from this set */
    public void clear() {
        table = (Node<E>[])new Node[table.length];
    }

    @Override /** Return true if the element is in the set */
    public boolean contains(E e) {
        int bucketIndex = hash(e.hashCode());
        Node<E> current = table[bucketIndex];
        boolean found = false;
        while (!found && current != null) {
            if (current.data.equals(e)) {
                found = true;
            } else {
                current = current.next;
            }
        }
        return found;
    }

    @Override /** Add an element to the set */
    public boolean add(E e) {
        int bucketIndex = hash(e.hashCode());
        Node<E> current = table[bucketIndex];
        boolean found = false;
        while (!found && current != null) {
            if (current.data.equals(e)) {
                found = true;
                // Already in the set
            } else {
                current = current.next;
            }
        }
        if (!found) {
            double loadFaktor = (size + 1) / table.length;
            if (loadFaktor > 0.75) {
                reHash();
            }
            Node newNode = new Node();
            newNode.data = e;
            newNode.next = table[bucketIndex];
            table[bucketIndex] = newNode;
            size++;
        }
        return !found;
    }

    public void reHash() {
        Node<E>[] temp = table;

        table = (Node<E>[]) new Node[temp.length*2 + 1];

        for (Node<E> node : temp) {
            Node<E> current = node;
            while (current != null) {
                add(current.data);
                current = current.next;
            }
        }
    }

    @Override /** Remove the element from the set */
    public boolean remove(E e) {
        int bucketIndex = hash(e.hashCode());
        Node<E> previous = null;
        Node<E> current = table[bucketIndex];
        boolean found = false;
        while (!found && current != null) {
            if (current.data.equals(e)) {
                found = true;
            } else {
                previous = current;
                current = current.next;
            }
        }
        if (found) {
            if (previous == null) {
                table[bucketIndex] = current.next;
            } else {
                previous.next = current.next;
            }
            size--;
        }
        return found;
    }

    @Override /** Return true if the set contains no elements */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override /** Return the number of elements in the set */
    public int size() {
        return size;
    }

    // method only for test purpose
    void writeOut() {
        for (int i = 0; i < table.length; i++) {
            Node<E> temp = table[i];
            if (temp != null) {
                System.out.print(i + "\t");
                while (temp != null) {
                    System.out.print(temp.data + "\t");
                    temp = temp.next;
                }
                System.out.println();
            }
        }
    }

   private class Node<E>{
        public E data;
        public Node<E> next;
    }

}
