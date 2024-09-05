class Node {
    public int value;  // Value stored in the node
    public Node next;  // Reference to the next node in the list

    // Constructor to initialize the node with a value
    public Node(int value) {
        this.value = value;
        this.next = null;  // Initially, the next reference is null
    }
}

public class LinkedListQueue {
    private Node head;  // Points to the front of the queue
    private Node tail;  // Points to the rear of the queue
    private int size;   // Number of elements in the queue

    // Constructor to initialize an empty queue
    public LinkedListQueue() {
        head = tail = null;  // Both head and tail are null for an empty queue
        size = 0;            // Size is 0 for an empty queue
    }

    // Method to add an element to the rear of the queue
    public void enqueue(int value) {
        Node newNode = new Node(value);  // Create a new node with the given value
        if (tail == null) {  // Check if the queue is empty
            head = tail = newNode;  // Both head and tail point to the new node
        } else {
            tail.next = newNode;  // Link the current tail node to the new node
            tail = newNode;       // Update the tail to the new node
        }
        size++;  // Increase the size of the queue
    }

    // Method to remove and return the element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {  // Check if the queue is empty
            throw new IllegalStateException("Queue is empty");
        }
        int value = head.value;  // Get the value from the front node
        head = head.next;  // Move the head to the next node
        if (head == null) {  // If the queue is now empty
            tail = null;  // Set tail to null as well
        }
        size--;  // Decrease the size of the queue
        return value;  // Return the removed value
    }

    // Method to get the element at the front of the queue without removing it
    public int peek() {
        if (isEmpty()) {  // Check if the queue is empty
            throw new IllegalStateException("Queue is empty");
        }
        return head.value;  // Return the value at the front of the queue
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;  // Queue is empty if size is 0
    }

    // Method to get the number of elements in the queue
    public int size() {
        return size;  // Return the current size of the queue
    }

    // Main method to test the LinkedListQueue class
    public static void main(String[] args) {
        // Create a new queue
        LinkedListQueue queue = new LinkedListQueue();
        
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
        
        // Print the new front element of the queue after dequeue
        System.out.println("New front element: " + queue.peek()); // Output: 20
        
        // Print the size of the queue after dequeue
        System.out.println("Queue size after dequeue: " + queue.size()); // Output: 2
        
        // Check if the queue is empty
        System.out.println("Is the queue empty? " + queue.isEmpty()); // Output: false
    }
}
