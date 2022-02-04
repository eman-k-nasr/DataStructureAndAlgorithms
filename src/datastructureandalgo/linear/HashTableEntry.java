package datastructureandalgo.linear;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @emankamal
 */
public class HashTableEntry<K, V> {

    LinkedList<HashTableNode<K, V>> items;

    public void add(K key, V value) {
        if (items == null) {
            items = new LinkedList<>();
        } else {
            for (HashTableNode<K,V> node : items) {
                if (node.getKey().equals(key)) {
                    throw new IllegalArgumentException("The collection already contains the key");
                }
            }
        }
        items.addHead(new HashTableNode(key, value));
    }

    public ArrayList<HashTableNode<K,V>> getEntryNodes() {
        ArrayList<HashTableNode<K,V>> nodes = new ArrayList<>();
        if (items != null) {
            for (HashTableNode<K, V> node : items) {
                nodes.add(node);
            }
        }
        return nodes;
    }
    
    public ArrayList<K> getEntryKeys() {
        ArrayList<K> keys = new ArrayList<>();
        if (items != null) {
            for (HashTableNode<K, V> node : items) {
                keys.add(node.getKey());
            }
        }
        return keys;
    }
    
    public ArrayList<V> getEntryValues() {
        ArrayList<V> values = new ArrayList<>();
        if (items != null) {
            for (HashTableNode<K, V> node : items) {
                values.add(node.getValue());
            }
        }
        return values;
    }
    
    private HashTableNode find(K key) {
        HashTableNode found = null;
        if (items != null) {
            for(HashTableNode current : items){
                if (current.getKey().equals(key)) {
                    found = current;
                    break;
                }
            }
        }
        return found;
    }
    
    public V getValue(K key){
       HashTableNode<K,V> found = find(key);
       if(found == null) return null;
       return found.getValue();
    }

    public boolean remove(K key) {
        boolean removed = false;
        HashTableNode found = find(key);
        if(found != null){
           items.remove(found);
           removed = true;
        }
        return removed;
    }
    
    public void clear(){
        if(items != null){
           items.clear();
        }
    }
}
