package datastructureandalgo.linear;

/**
 *
 * @author eman kamal
 */
public class Queue<T>{
    private Deque<T> deque = new Deque<>();
    
    public void enqueue(T element){
      deque.enqueueTail(element);
    }
    
    public T dequeue(){
      return deque.dequeueHead();
    }
    
    public int count(){
      return deque.count();
    }
    
    public T peek(){
      return deque.first();
    }
    
    public void printData(){
       deque.printForward();
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.printData();
        queue.dequeue();
        queue.printData();
    }

}
