package datastructureandalgo.linear;

import java.util.ArrayList;

/**
 *
 * @emankamal
 */
public class HashTable<K, V> {

    private final static double fillFactor = 0.80;
    private int maxItemsAtCurrentSize;
    private int count;
    private HashTableArray<K,V> hashTableArray;

    public HashTable() {
        this(100);
    }

    public HashTable(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException();
        }
        hashTableArray = new HashTableArray(capacity);
        // when the count exceeds this , the next Add will cause array to grow
        maxItemsAtCurrentSize = (int) (capacity * fillFactor) + 1;
    }

    public void put(K key, V value) {
        if (count >= maxItemsAtCurrentSize) {
            // allocate a larger array
            HashTableArray largerArr = new HashTableArray(hashTableArray.size() * 2);
            for(HashTableEntry entry : hashTableArray.getEntries()){
               largerArr.add(key, value);
            }
            hashTableArray = largerArr;
            maxItemsAtCurrentSize = (int) (hashTableArray.size() * fillFactor) + 1;
        }
        hashTableArray.add(key, value);
        count++;
    }
    
    public boolean remove(K key) {
        boolean removed = hashTableArray.remove(key);
        if (removed) {
            count--;
        }
        return removed;
    }
    
    public V getValue(K key){
        return hashTableArray.getValue(key);
    }
    
    public void clear() {
        hashTableArray.clear();
        count = 0;
    }
            
    public int count(){
       return count;
    }
    
    public ArrayList<HashTableNode<K,V>> entries(){
        return hashTableArray.getNodes();
    }
    
    public ArrayList<K> keys(){
       return hashTableArray.getKeys();
    }
    
    public ArrayList<V> values(){
       return hashTableArray.getValues();
    }
    
    public static void main(String[] args) {
        HashTable<String,String> hashTable = new HashTable(10);
        hashTable.put("user1", "eman");
        hashTable.put("user2", "sara");
        hashTable.put("user3", "rania");
        hashTable.put("user4", "tasnim");
        System.out.println("size: "+hashTable.count());
        System.out.println("get user1: "+hashTable.getValue("user1"));
        hashTable.remove("user2");
        System.out.println("size: "+hashTable.count());
        System.out.println("get user4: "+hashTable.getValue("user4"));
//        hashTable.put("user4", "tsts");
//        System.out.println("get user4: "+hashTable.getValue("user4"));
        for(String key : hashTable.keys()){
            System.out.print(key+",");
        }
        System.out.println("");
        for(String value : hashTable.values()){
            System.out.print(value+",");
        }
        System.out.println("");
        for(HashTableNode<String,String> node : hashTable.entries()){
            System.out.print("["+node.getKey()+":"+node.getValue()+"]"+",");
        }


        
    }

}
