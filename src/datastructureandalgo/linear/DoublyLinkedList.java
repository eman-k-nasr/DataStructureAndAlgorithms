/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructureandalgo.linear;

import java.util.NoSuchElementException;

/**
 *
 * @author eman kamal 
 */
public class DoublyLinkedList<T> {
    private Node head;
    private Node tail;
    private int size;
    
    public DoublyLinkedList(){
       size = 0;
    }
    public class Node{
        T element;
        Node next;
        Node prev; 
        public Node(T element,Node next, Node prev){
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
    
    public Node getHead(){
       return head;
    }
    
    public Node getTail(){
       return tail;
    }
    
    public int size(){
      return size;
    }
    
    public Boolean isEmpty(){
      return size == 0;
    }
    
    public void addHead(T element){
        Node temp = new Node(element,head,null);
        if(head != null){
           head.prev = temp;
        }
        head = temp;
        if(tail == null){
            tail = temp;
        }
        size++;
        System.out.println("Adding Head: "+element);
    }
    
    public void addTail(T element){
        Node temp = new Node(element, null, tail);
        if(tail != null){
            tail.next = temp;
        }
        tail = temp;
        if(head == null){
          head = temp;
        }
        size++;
        System.out.println("Adding Tail: "+element);
    }
    
    public Node find(T element){
        Node current = head;
        while(current != null){
          if(current.element.equals(element)){
            return current;
          }
          current = current.next;
        }
        throw new NoSuchElementException();
    }
    
    public T removeHead(){
        if(isEmpty()) throw new NoSuchElementException();
        Node temp = head;
        Node n = head.next;
        head = n;
        if(head != null){
          head.prev = null;
        }
        size--;
        System.out.println("removed Head: "+temp.element);
        return temp.element;
    }
    
    public T removeTail(){
        if(isEmpty()) throw new NoSuchElementException();
        Node temp = tail;
        Node p = tail.prev;
        tail = p;
        if(tail != null){
          tail.next = null;
        }
        size--;
        System.out.println("removed Tail: "+temp.element);
        return temp.element;
    }
    
    public T removeElement(T element){
        Node node = find(element);
        Node p = node.prev;
        Node n = node.next;
        if(node == head){
          System.out.println("node to be deleted is head");
          return removeHead();
        }else if(node == tail){
          System.out.println("node to be deleted is tail");
          return removeTail();
        }else{
            System.out.println("node to be deleted is some node");
            p.next = n;
            n.prev = p;
            return node.element;
        }
    }
    
    public void iterateForwad(){
       Node current = head;
       while(current != null){
         System.out.print(current.element+" ");
         current = current.next;
       }
        System.out.println();
    }
    
    public void iterateBackward(){
       Node current = tail;
       while(current != null){
         System.out.print(current.element+" ");
         current = current.prev;
       }
       System.out.println();
    }
    
    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList();
        dll.addHead(2);//2-> NULL
        dll.addHead(4);//4->2-> NULL
        dll.addHead(8);//8->4->2-> NULL
        dll.addHead(10);//10->8->4->2-> NULL
        System.out.println("head is: "+dll.head.element+" tail is :"+dll.tail.element);
        System.out.println("size is : "+dll.size);
        dll.iterateForwad();
        
        dll.addTail(6);//10->8->4->2->6-> NULL
        dll.addTail(7);//10->8->4->2->6->7-> NULL
        System.out.println("head is: "+dll.head.element+" tail is :"+dll.tail.element);
        System.out.println("size is : "+dll.size);
        dll.iterateForwad();
        
        System.out.println("-----iterate backward-------");
        dll.iterateBackward();
        
        //10->8->4->2->6->7-> NULL
        Integer removedHead1 = dll.removeHead();//8->4->2->6->7-> NULL
        System.out.println("removed "+removedHead1);
        System.out.println("size is : "+dll.size);
        dll.iterateForwad();
        
        Integer removedElement1 = dll.removeElement(8);//4->2->6->7-> NULL
        System.out.println("removed "+removedElement1);
        dll.iterateForwad();
        
        Integer removedTail1 = dll.removeTail();//4->2->6->NULL
        System.out.println("removed "+removedTail1);
        dll.iterateForwad();
        
        Integer removedElement2 = dll.removeElement(6);//4->2->NULL
        System.out.println("removed "+removedElement2);
        dll.iterateForwad();
        
        dll.addTail(3);//4->2->3->NULL
        dll.iterateForwad();
        
        Integer removedElement3 = dll.removeElement(2);//4->3->NULL   
        System.out.println("removed "+removedElement3);
        dll.iterateForwad(); 
        
        dll.removeTail();
        dll.removeElement(4);
        dll.iterateForwad();
        
//        dll.removeHead(); //3
//        dll.removeElement(3);
//        dll.removeElement(2); //throw exception
//        dll.removeHead();//throw exception
    }
    
}
