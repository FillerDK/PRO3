package opg2.dictionaryelev;

import java.util.ArrayList;
import java.util.List;

public class DictionaryList<K, V> implements opg2.dictionaryelev.Dictionary<K, V> {

    private List<KeyValuePair>[] tabel;
    private static int N = 13;
    private int size = 0;

    /**
     * HashingList constructor comment.
     */

    public DictionaryList() {
        tabel = new List[N];
        for (int i = 0; i < N; i++) {
            tabel[i] = new ArrayList<>();
        }
    }

    public class KeyValuePair {
        K key;
        V value;

        public KeyValuePair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public V get(K key) {
        List<KeyValuePair> temp = tabel[key.hashCode() % N];
        V res = null;
        boolean found = false;

        for (int i = 0; !found && i < temp.size(); i++) {
            KeyValuePair kvp = temp.get(i);
            if (kvp.key.equals(key)) {
                res = kvp.value;
                found = true;
            }
        }
        return res;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // O(n)
    @Override
    public V put(K key, V value) {
        List<KeyValuePair> temp = tabel[key.hashCode() % N];

        V res = null;
        boolean found = false;

        for (int i = 0; !found && i < temp.size(); i++) {
            KeyValuePair kvp = temp.get(i);
            if (kvp.key.equals(key)) {
                res = kvp.value;
                temp.set(i, new KeyValuePair(key, value)); // replace old value
                return res;
            }
        }

        temp.add(new KeyValuePair(key, value));
        size++;

        return null;
    }

    @Override
    public V remove(K key) {
        List<KeyValuePair> temp = tabel[key.hashCode() % N];
        V res = null;
        boolean found = false;

        for (int i = 0; !found && i < temp.size(); i++) {
            KeyValuePair kvp = temp.get(i);
            if (kvp.key.equals(key)) {
                res = kvp.value;
                temp.remove(kvp);
                found = true;
                size--;
            }
        }
        return res;
    }

    @Override
    public int size() {
        return size;
    }
}
