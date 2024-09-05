/*
 * Q2. Queue Using Stacks

 */

import java.util.Stack;

public class Q2_QueueUsingStacks {

    private Stack<Integer> enQueueStack;
    private Stack<Integer> deQueueStack;

    Q2_QueueUsingStacks() {
        enQueueStack = new Stack<>();
        deQueueStack = new Stack<>();
    }
     /** Push element X to the back of queue. */
     public void push(int X) {
        enQueueStack.push(X);
     }
     
     /** Removes the element from in front of queue and returns that element. */
     public int pop() {
        int val = 0;
        if(deQueueStack.isEmpty()) {
            while (!enQueueStack.isEmpty()) {
                deQueueStack.push(enQueueStack.pop());
            }
        }
        return deQueueStack.pop();
     }
     
     /** Get the front element of the queue. */
     public int peek() {
         if(deQueueStack.isEmpty()) {
            while (!enQueueStack.isEmpty()) {
                deQueueStack.push(enQueueStack.pop());
            }
         }
         return deQueueStack.peek();
     }
     
     /** Returns whether the queue is empty. */
     public boolean empty() {
        return enQueueStack.isEmpty() && deQueueStack.isEmpty();
     }
 
    public static void main(String[] args) {
        Q2_QueueUsingStacks queue = new Q2_QueueUsingStacks();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek()); // Should return 1
        System.out.println(queue.pop());  // Should return 1
        System.out.println(queue.empty()); // Should return false

    }
}
