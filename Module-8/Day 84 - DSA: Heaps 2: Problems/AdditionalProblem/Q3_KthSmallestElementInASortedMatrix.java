/*
 * Q3. Kth Smallest Element in a Sorted Matrix

 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q3_KthSmallestElementInASortedMatrix {

    public static int solve(ArrayList<ArrayList<Integer>> A, int B) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                if(maxHeap.size() < B) {
                    maxHeap.add(A.get(i).get(j));
                } else {
                    if(A.get(i).get(j) < maxHeap.peek()) {
                        maxHeap.poll();
                        maxHeap.add(A.get(i).get(j));
                    }
                }
                   
               
            }
        }
        System.out.println(maxHeap);
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>(
                Arrays.asList(
                        new ArrayList<>(Arrays.asList(9, 11, 15)),
                        new ArrayList<>(Arrays.asList(10, 15, 17))
                        // new ArrayList<>(Arrays.asList(10, 12, 15)),
                        // new ArrayList<>(Arrays.asList(13, 14, 16)),
                        // new ArrayList<>(Arrays.asList(16, 20, 21))
                        ));

        System.out.println(solve(A, 6));
    }
}
