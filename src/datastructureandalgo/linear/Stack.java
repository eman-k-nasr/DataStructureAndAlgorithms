package datastructureandalgo.linear;

/**
 *
 * @author eman kamal
 */
public class Stack<T>{
    private Deque<T> deque = new Deque<>();

    public void push(T element) {
        deque.enqueueHead(element);
    }

    public T pop() {
        return deque.dequeueHead();
    }

    public int count() {
        return deque.count();
    }

    public T peek() {
        return deque.first();
    }

    public void printData(){
      deque.printForward();
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printData();
        stack.pop();
        stack.printData();
    }
}
