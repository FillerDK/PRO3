package afleveringsOpgave;

import afleveringsOpgave.Dictionary;

public class DictionaryDoubleHashing <K, V> implements Dictionary<K, V> {
    private Entry<K,V>[] table;
    private int size;

   private final Entry DELETED = new Entry(null,null);

    public DictionaryDoubleHashing() {
        table =  new Entry[10];
        size = 0;
    }

    // Størrelsesordenen O(1)
    public int hash(int hashCode) {
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        return hashCode % table.length;
    }


    // Størrelsesordenen O(n)
    @Override
    public V get(K key) {
        int bucketIndex = hash(key.hashCode());
        Entry<K, V> e = table[bucketIndex];
        boolean found = false;

        if (e != null && key.equals(e.getKey())) {
            found = true; // Key exists
        }

        if (!found) {
            // Double hashing
            int newHash = 7 - (hash(key.hashCode()) % 7);
            bucketIndex += newHash;
            e = table[bucketIndex % table.length];

            while (!found && e != null) {
                if (key.equals(e.getKey())) {
                    found = true; // Key exists
                } else {
                    bucketIndex += newHash;
                    e = table[bucketIndex % table.length];
                }
            }
        }

        if (found) {
            return e.getValue();
        }

        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public V put(K key, V value) {
        int bucketIndex = hash(key.hashCode());
        Entry<K, V> e = table[bucketIndex];
        boolean found = false;

        if (e == null) {
            // New entry
        } else if (!key.equals(e.getKey())) {
            // Double hashing
            int newHash = 7 - (hash(key.hashCode()) % 7);
            bucketIndex += newHash;
            e = table[bucketIndex % table.length];

            while (!found && e != null) {
                if (key.equals(e.getKey())) {
                    found = true; // Key exists
                } else {
                    bucketIndex += newHash;
                    e = table[bucketIndex % table.length];
                }
            }
        }

        if (!found) {
            Entry<K, V> newEntry = new Entry<>(key, value);
            table[bucketIndex % table.length] = newEntry;
            size++;
            double loadfaktor = (double) size / table.length;
            if (loadfaktor > 0.5) {
                reHash();
            }
            return null;
        } else {
            V temp = e.getValue();
            e.value = value;
            return temp;
        }
    }

    private void reHash() {
        Entry[] temp = table;

        table = new Entry[table.length*2 + 1];
        size = 0;

        for (Entry e : temp) {
            if (e != null && !e.equals(DELETED)) {
                put((K) e.getKey(), (V) e.getValue());
            }
        }
    }

    @Override
    public V remove(K key) {
        int bucketIndex = hash(key.hashCode());
        Entry<K, V> e = table[bucketIndex];
        boolean found = false;

        if (e != null && key.equals(e.getKey())) {
            found = true; // Key exists
        }

        if (!found) {
            // Double hashing
            int newHash = 7 - (hash(key.hashCode()) % 7);
            bucketIndex += newHash;
            e = table[bucketIndex % table.length];

            while (!found && e != null) {
                if (key.equals(e.getKey())) {
                    found = true; // Key exists
                } else {
                    bucketIndex += newHash;
                    e = table[bucketIndex % table.length];
                }
            }
        }

        if (found) {
            V temp = e.getValue();
            table[bucketIndex] = DELETED;
            size--;
            return temp;
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }


    // method only for test purpose
    public void writeOut() {
        for (int i = 0; i < table.length; i++) {
            System.out.println(i + "\t" + table[i]);
        }
    }

    public static class Entry<K,V>{
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
        public String toString(){
            return "(" + key + " , " + value + ")";
        }
    }
}
