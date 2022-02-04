package datastructureandalgo.linear;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @emankamal
 */
public class LinkedList<T> implements Iterable<T> {

    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size;

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(head);
    }

    public class LinkedListIterator implements Iterator<T> {

        private LinkedListNode<T> current;

        public LinkedListIterator(LinkedListNode<T> head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            LinkedListNode<T> temp = current;
            current = current.next;
            return temp.element;
        }
    }

    public LinkedListNode<T> getHead() {
        return head;
    }

    public LinkedListNode<T> getTail() {
        return tail;
    }

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public void addHead(T element) {
        LinkedListNode<T> temp = new LinkedListNode<>(element);
        if (isEmpty()) {
            head = tail = temp;
            temp.next = null;
        } else {
            temp.next = head;
            head = temp;
        }
        size++;
        System.out.println("Adding Head: " + element);
    }

    public void addTail(T element) {
        LinkedListNode<T> temp = new LinkedListNode<>(element);
        if (isEmpty()) {
            head = tail = temp;
            temp.next = null;
        } else {
            tail.next = temp;
            temp.next = null;
            tail = temp;
        }
        size++;
        System.out.println("Adding Tail: " + element);

    }

    public void iterateForward() {
        LinkedListNode<T> current = head;
        while (current != null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

    public T removeHead() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        LinkedListNode<T> temp = head;
        if (size == 1) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        System.out.println("removed Head: " + temp.element);
        return temp.element;
    }

    public T removeTail() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        LinkedListNode<T> temp = tail;
        if (size == 1) {
            head = tail = null;
        } else {
            LinkedListNode<T> current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
        size--;
        System.out.println("removed Tail: " + temp.element);
        return temp.element;
    }

    public T remove(T element){
        LinkedListNode<T> node = find(element);
        LinkedListNode<T> current;
        LinkedListNode<T> prev;
        if(node == head){
          System.out.println("node to be deleted is head");
          return removeHead();
        }else if(node == tail){
          System.out.println("node to be deleted is tail");
          return removeTail();
        }else{
          System.out.println("node to be deleted is some node");
          current = head.next;
          prev = head;
          while(current != null && !(current.element.equals(element))){
              prev = current;
              current = current.next;
          }
          if(current == null) return null;
          prev.next = current.next;
          if(current == tail) tail = prev;
          size--;
          return current.element;
          
        }
    }
    
    public LinkedListNode<T> find(T element) {
        LinkedListNode<T> current = head;
        while (current != null) {
            if (current.element.equals(element)) {
                return current;
            }
            current = current.next;
        }
        throw new NoSuchElementException();
    }
    
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addHead(2);//2-> NULL
        linkedList.addHead(4);//4->2-> NULL
        linkedList.addHead(8);//8->4->2-> NULL
        linkedList.addHead(10);//10->8->4->2-> NULL
        System.out.println("head is: " + linkedList.head.element + " tail is :" + linkedList.tail.element);
        System.out.println("size is : " + linkedList.size);
        linkedList.iterateForward();

        linkedList.addTail(6);//10->8->4->2->6-> NULL
        linkedList.addTail(7);//10->8->4->2->6->7-> NULL
        System.out.println("head is: " + linkedList.head.element + " tail is :" + linkedList.tail.element);
        System.out.println("size is : " + linkedList.size);
        linkedList.iterateForward();

        //10->8->4->2->6->7-> NULL
        Integer removedHead1 = linkedList.removeHead();//8->4->2->6->7-> NULL
        System.out.println("removed " + removedHead1);
        System.out.println("size is : " + linkedList.size);
        linkedList.iterateForward();

        Integer removedTail1 = linkedList.removeTail();
        System.out.println("removed " + removedTail1);
        linkedList.iterateForward();
        
        Integer removedElement1 = linkedList.remove(4);
        System.out.println("removed " + removedElement1);
        linkedList.iterateForward();
        
        Integer removedElement2 = linkedList.remove(8);
        System.out.println("removed " + removedElement2);
        linkedList.iterateForward();
        
        Integer removedElement3 = linkedList.remove(6);
        System.out.println("removed " + removedElement3);
        linkedList.iterateForward();
        
        Integer removedElement4 = linkedList.remove(2);
        System.out.println("removed " + removedElement4);
        linkedList.iterateForward();

    }

}
