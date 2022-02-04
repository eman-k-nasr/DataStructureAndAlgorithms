package datastructureandalgo.linear;

import java.util.ArrayList;

/**
 *
 * @emankamal
 */
public class HashTableArray<K, V> {

    private ArrayList<HashTableEntry> allEntries;

    public HashTableArray(int capacity) {
        allEntries = new ArrayList(capacity);
        for (int i = 0; i < capacity; i++) {
            allEntries.add(i, new HashTableEntry());
        }
    }

    public void add(K key, V value) {
        HashTableEntry<K, V> entry = allEntries.get(getKeyIndex(key));
        entry.add(key, value);
    }

    public V getValue(K key) {
        HashTableEntry<K, V> entry = allEntries.get(getKeyIndex(key));
        return entry.getValue(key);
    }

    public boolean remove(K key) {
        HashTableEntry<K, V> entry = allEntries.get(getKeyIndex(key));
        return entry.remove(key);
    }

    public void clear() {
        for (HashTableEntry entry : allEntries) {
            entry.clear();
        }
    }

    private int getKeyIndex(K key) {
        return Math.abs(key.hashCode() % size());
    }

    public ArrayList<HashTableEntry> getEntries() {
        return allEntries;
    }

    public ArrayList<HashTableNode<K,V>> getNodes(){
       ArrayList<HashTableNode<K,V>> allEntriesNodes = new ArrayList<>();
        for (HashTableEntry<K, V> entry : allEntries) {
            for (HashTableNode node : entry.getEntryNodes()) {
                allEntriesNodes.add(node);
            }
        }
        return allEntriesNodes;
    }
    public ArrayList<K> getKeys() {
        ArrayList<K> allEntriesKeys = new ArrayList<>();
        for (HashTableEntry<K, V> entry : allEntries) {
            for (K key : entry.getEntryKeys()) {
                allEntriesKeys.add(key);
            }
        }
        return allEntriesKeys;
    }

    public ArrayList<V> getValues() {
        ArrayList<V> allEntriesValues = new ArrayList<>();
        for (HashTableEntry<K, V> entry : allEntries) {
            for (V value : entry.getEntryValues()) {
                allEntriesValues.add(value);
            }
        }
        return allEntriesValues;
    }

    public int size() {
        return allEntries.size();
    }
}
