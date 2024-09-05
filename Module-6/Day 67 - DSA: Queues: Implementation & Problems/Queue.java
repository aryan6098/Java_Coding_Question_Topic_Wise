import java.util.ArrayList;


public class Queue {

    public static int size = 0;
    public static int r = -1;
    public static int f = -1;
    public static void enqueue(ArrayList<Integer> queue, int val) {
        queue.add(val);
        size++;
    }
    public static void dequeue(ArrayList<Integer> queue) {
        
        queue.remove(0);
        size--;
    }

    public static int peek(ArrayList<Integer> queue) {
        // if(queue.isEmpty()) {
        //     return ;
        // }
        return queue.get(0);
    }

    public static boolean isEmpty(ArrayList<Integer> queue) {
        return queue.isEmpty();
    }

    public static void arrEnqueue(int[] A, int val) {
       
        if(size == A.length) {
            return;
        }
        r = (r+1)% A.length;
        A[r] = val;
        size++;
    }

    public static int arrDequeue(int[] A) {
        if(size == 0) {
            return -1;
        }

        f = (f + 1)% A.length;
        int val = A[f];
        size--;
        if (size == 0) {
            f = -1;
            r = -1;
        }
        return val;
    }
    public static int arrQueuePeek(int[] A) {
        if(size == 0) {
            return -1;
        }
        return A[f];
    }

    public static int arrSize() {
        return size;
    }


    public static void main(String[] args) {


        // Queue is using Arraylist
        ArrayList<Integer> queue = new ArrayList<>();
        enqueue(queue, 32);
        enqueue(queue, 4);
        enqueue(queue, 5);
        enqueue(queue, 36);
        enqueue(queue, 5);
        enqueue(queue, 3);
        System.out.println(peek(queue));
        dequeue(queue); 
        dequeue(queue);
        dequeue(queue);
        System.out.println(queue);
        ///


        int[] arr = new int[10];
       arrEnqueue(arr, 3);
       arrEnqueue(arr, 4);
      System.out.println("Dequeue : "+ arrDequeue(arr));
    //   arrEnqueue(arr, 49);
        // for(int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] +" ");
        // }


    }
}
