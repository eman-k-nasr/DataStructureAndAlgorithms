package datastructureandalgo.linear;

import java.util.ArrayList;

/**
 *
 * @author eman kamal
 */
public class StackByArray<T> {

    ArrayList<T> items;
    int top = -1;
    int size = 0;

    public StackByArray() {
        this.items = new ArrayList<>();
    }

    void push(T item) {
        if (top >= size) {
            System.out.println("Stack Overflow");
        } else {
            items.add(item);
            top++;
            size++;
        }
    }

    T getTop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            return items.get(top);
        }
    }

    T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        } else {
            T item = getTop();
            items.remove(top);
            top--;
            size--;
            return item;
        }
    }

    boolean isEmpty() {
        return top == -1;
    }

    @Override
    public String toString() {
        String res = "[";
        for (int i = top; i >= 0; i--) {
            res += String.valueOf(items.get(i)) + " ";
        }
        res += "]";
        return res;
    }
    
    
    public static void main(String[] args) {
     StackByArray<Integer> s1 = new StackByArray<>();
     s1.push(10);
     s1.push(20);
     s1.push(30);
     System.out.println(s1);
     System.out.println("top "+ s1.getTop());
     System.out.println("size "+ s1.size);
     int popped1 = s1.pop();
     System.out.println("popping1 "+ popped1);
     System.out.println(s1);
     System.out.println("top "+ s1.getTop());
     System.out.println("size "+ s1.size);
     int popped2 = s1.pop();
     System.out.println("popping2 "+ popped2);
     System.out.println(s1);
     System.out.println("top "+ s1.getTop());
     System.out.println("size "+ s1.size);
     int popped3 = s1.pop();
     System.out.println("popping3 "+ popped3);
     System.out.println(s1);
     System.out.println("top "+ s1.getTop());
     System.out.println("size "+ s1.size);
     
    }
}
