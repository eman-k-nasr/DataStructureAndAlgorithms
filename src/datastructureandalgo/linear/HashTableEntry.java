package datastructureandalgo.linear;

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
                    node.updateValue(value);
                }
            }
        }
        items.addHead(new HashTableNode(key, value));
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
