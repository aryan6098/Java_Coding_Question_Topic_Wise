import java.util.ArrayList;

public class ArrayListQueue {
    // ArrayList to hold the queue elements
    private ArrayList<Integer> list;
    
    // Constructor to initialize the ArrayList
    public ArrayListQueue() {
        list = new ArrayList<>();
    }

    // Method to add an element to the rear of the queue
    public void enqueue(int value) {
        list.add(value);
    }

    // Method to remove and return the element from the front of the queue
    public int dequeue() {
        // Check if the queue is empty before removing an element
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        // Remove and return the element at the front (index 0)
        return list.remove(0);
    }

    // Method to get the element at the front of the queue without removing it
    public int peek() {
        // Check if the queue is empty before accessing an element
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        // Return the element at the front (index 0)
        return list.get(0);
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Method to get the number of elements in the queue
    public int size() {
        return list.size();
    }
    
    // Main method to test the ArrayListQueue class
    public static void main(String[] args) {
        // Create a new queue
        ArrayListQueue queue = new ArrayListQueue();
        
        // Enqueue some elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        // Print the front element of the queue
        System.out.println("Front element: " + queue.peek()); // Output: 10
        
        // Print the size of the queue
        System.out.println("Queue size: " + queue.size()); // Output: 3
        
        // Dequeue an element and print it
        System.out.println("Dequeued element: " + queue.dequeue()); // Output: 10
        
        // Print the front element of the queue after dequeue
        System.out.println("New front element: " + queue.peek()); // Output: 20
        
        // Print the size of the queue after dequeue
        System.out.println("Queue size after dequeue: " + queue.size()); // Output: 2
        
        // Check if the queue is empty
        System.out.println("Is the queue empty? " + queue.isEmpty()); // Output: false
    }
}
