/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureandalgo.linear;

import java.util.NoSuchElementException;

/**
 *
 * @author pc
 */
public class Deque<T> {

    private DoublyLinkedList<T> list = new DoublyLinkedList<>();
    
    public void enqueueHead(T element) {
        list.addHead(element);
    }

    public void enqueueTail(T element) {
        list.addTail(element);
    }
    
    public T dequeueHead(){
       if(list.getHead()!=null){
         return list.removeHead();
       }
       return null;
    }
    
    public T dequeueTail(){
       if(list.getTail() != null){
         return list.removeTail();
       }
       return null;
    }
    
    public T first(){
        if(list.getHead() != null){
           return list.getHead().element;
        }
        throw new NoSuchElementException(); 
    }
    
    public T last(){
        if(list.getTail() != null){
           return list.getTail().element;
        }
        throw new NoSuchElementException(); 
    }
    
    public int count(){
      return list.size();
    }
    
    public void printForward(){
        list.iterateForward();
    }
    
    public void printBackward(){
        list.iterateBackward();
    }
}
