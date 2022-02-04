package datastructureandalgo.linear;

import java.util.NoSuchElementException;

/**
 *
 * @emankamal
 */
public class LinkedList<T> {

    private Node head;
    private Node tail;
    private int size;

    class Node {

        T element;
        Node next;

        Node(T element) {
            this.element = element;
        }

    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int size() {
        return size;
    }

    public Boolean isEmpty() {
        return size == 0;
    }

    public void addHead(T element) {
        Node temp = new Node(element);
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
        Node temp = new Node(element);
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
        Node current = head;
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
        Node temp = head;
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
        Node temp = tail;
        if (size == 1) {
            head = tail = null;
        } else {
            Node current = head;
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

    public Node find(T element) {
        Node current = head;
        while (current != null) {
            if (current.element.equals(element)) {
                return current;
            }
            current = current.next;
        }
        throw new NoSuchElementException();
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
        System.out.println("removed "+removedHead1);
        System.out.println("size is : "+linkedList.size);
        linkedList.iterateForward();
        
        Integer removedTail1 = linkedList.removeTail();
        System.out.println("removed "+removedTail1);
        linkedList.iterateForward();
    }

}
