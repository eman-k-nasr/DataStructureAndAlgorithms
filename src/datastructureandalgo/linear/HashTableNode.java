/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureandalgo.linear;

/**
 *
 * @author pc
 */
public class HashTableNode<K,V>{

    private K key;
    private V value;

    HashTableNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
    
    public K getKey(){
      return key;
    }
    
    public void updateValue(V value){
        this.value = value;
    }
    
    public V getValue(){
      return value;
    }
}
