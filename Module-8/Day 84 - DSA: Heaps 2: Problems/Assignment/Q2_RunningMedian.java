/*
 * Problem Description

Flipkart is currently dealing with the difficulty of precisely estimating and displaying the expected delivery time for orders to a specific pin code. The existing method relies on historical delivery time data for that pin code, using the median value as the expected delivery time. As the order history expands with new entries, Flipkart aims to enhance this process by dynamically updating the expected delivery time whenever a new delivery time is added. The objective is to find the expected delivery time after each new element is incorporated into the list of delivery times. End Goal: With every addition of new delivery time, requirement is to find the median value.

Why Median ? The median is calculated because it provides a more robust measure of the expected delivery time The median is less sensitive to outliers or extreme values than the mean. In the context of delivery times, this is crucial because occasional delays or unusually fast deliveries (outliers) can skew the mean significantly, leading to inaccurate estimations.


Given an array of integers, A denoting the delivery times for each order. New arrays of integer B and C are formed, each time a new delivery data is encountered, append it at the end of B and append the median of array B at the end of C. Your task is to find and return the array C.

NOTE:

If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).



Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 109



Input Format

The only argument given is the integer array A.



Output Format

Return an integer array C, C[i] denotes the median of the first i delivery times.



Example Input

Input 1:

 A = [1, 2, 5, 4, 3]
Input 2:

 A = [5, 17, 100, 11]




Example Output

Output 1:

 [1, 1, 2, 2, 3]
Output 2:

 [5, 5, 17, 11]




Example Explanation

Explanation 1:



 Delivery Times      median
 [1]                   1
 [1, 2]                1
 [1, 2, 5]             2 
 [1, 2, 5, 4]          2
 [1, 2, 5, 4, 3]       3
Explanation 2:

 Delivery Times     median
 [5]                  5
 [5, 17]              5
 [5, 17, 100]         17
 [5, 17, 100, 11]     11 
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2_RunningMedian {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {

        // ArrayList<Integer> result = new ArrayList<>();
        // PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // maxHeap.add(A.get(0));
        // maxHeap.add(A.get(1));

        // minHeap.add(maxHeap.poll());
        // for(int i = 2; i < A.size(); i++) {
        //     if(A.get(i) >= minHeap.peek()){
        //         minHeap.add(A.get(i));
        //     }else {
        //         maxHeap.add(A.get(i));
        //     }
        //     int diff = Math.abs(minHeap.size() - maxHeap.size());
        //     if(diff > 1) {
        //         if(minHeap.size() > maxHeap.size()) {
        //             maxHeap.add(minHeap.poll());
        //         }else{ 
        //             minHeap.add(maxHeap.poll());
        //         }
        //     }
        //     if(minHeap.size() > maxHeap.size()) {
        //         System.out.println(minHeap.peek());
        //     }else if(maxHeap.size() > minHeap.size()) {
        //         System.out.println(maxHeap.peek());
        //     }else {
        //         System.out.println((minHeap.peek() + maxHeap.peek())/2);
        //     }
            
        // }
        // return result;

        ArrayList<Integer> result = new ArrayList<>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); 
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a); 
        for (int num : A) {
            // Step 1: Add number to maxHeap or minHeap
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }

            // Step 2: Balance the heaps to ensure maxHeap has equal or one extra element
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            // Step 3: Append the median to result
            if (maxHeap.size() >= minHeap.size()) {
                // maxHeap has the left middle element when sizes are balanced or maxHeap is larger
                result.add(maxHeap.peek());
            } else {
                result.add(minHeap.peek());
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(59,64,10,39));
       System.out.println( solve(A));
    }
}