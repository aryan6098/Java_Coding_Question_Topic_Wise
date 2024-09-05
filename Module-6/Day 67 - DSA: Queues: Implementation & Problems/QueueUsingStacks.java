import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> stack1; // Stack for enqueue operations
    private Stack<Integer> stack2; // Stack for dequeue operations

    // Constructor to initialize the stacks
    public QueueUsingStacks() {
        stack1 = new Stack<>(); // Initialize the first stack
        stack2 = new Stack<>(); // Initialize the second stack
    }

    // Method to add an element to the queue
    public void enqueue(int value) {
        stack1.push(value); // Push the new element onto stack1
    }

    // Method to remove and return the front element of the queue
    public int dequeue() {
        // If stack2 is empty, transfer all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new IllegalStateException("Queue is empty"); // Throw exception if both stacks are empty
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop()); // Move elements from stack1 to stack2
            }
        }
        return stack2.pop(); // Pop the top element from stack2
    }

    // Method to peek at the front element without removing it
    public int peek() {
        // If stack2 is empty, transfer all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                throw new IllegalStateException("Queue is empty"); // Throw exception if both stacks are empty
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop()); // Move elements from stack1 to stack2
            }
        }
        return stack2.peek(); // Peek at the top element of stack2
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty(); // Queue is empty if both stacks are empty
    }

    // Method to get the number of elements in the queue
    public int size() {
        return stack1.size() + stack2.size(); // Return the total number of elements in both stacks
    }

    // Main method to test the queue implementation
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks(); // Create a new queue instance

        // Test enqueue operations
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        // Test peek operation
        System.out.println("Front element: " + queue.peek());  // Output: 1
        
        // Test dequeue operation
        System.out.println("Dequeued element: " + queue.dequeue());  // Output: 1
        
        // Test peek operation after dequeue
        System.out.println("Front element after dequeue: " + queue.peek());  // Output: 2
        
        // Test queue size
        System.out.println("Queue size: " + queue.size());  // Output: 2
        
        // Test isEmpty operation
        System.out.println("Is queue empty? " + queue.isEmpty());  // Output: false

    }
}
