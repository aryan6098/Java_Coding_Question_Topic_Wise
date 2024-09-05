public class ArrayQueue {
    private int[] queue;
    private int front, rear, size;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayQueue() {
        queue = new int[DEFAULT_CAPACITY];
        front = rear = size = 0;
    }

    public void enqueue(int value) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue is full");
        }
        queue[rear] = value;
        rear = (rear + 1) % queue.length;
        size++;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        int value = queue[front];
        front = (front + 1) % queue.length;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(3);
        queue.enqueue(35);
        queue.enqueue(45);
        queue.enqueue(34);
        System.out.println(queue.peek());
        queue.dequeue();
        System.out.println(queue.peek());
        System.out.println(queue.size());

    }
}