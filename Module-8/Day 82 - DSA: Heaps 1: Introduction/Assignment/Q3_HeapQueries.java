/*
 * Q3. Heap Queries
Problem Description

You have an empty min heap. You are given an array A consisting of N queries. Let P denote A[i][0] and Q denote A[i][1]. There are two types of queries:

P = 1, Q = -1 : Pop the minimum element from the heap.
P = 2, 1 <= Q <= 109 : Insert Q into the heap.

Return an integer array containing the answer for all the extract min operation. If the size of heap is 0, then extract min should return -1.



Problem Constraints

1 <= N <= 105

1 <= A[i][0] <= 2

1 <= A[i][1] <= 109 or A[i][1] = -1



Input Format

The only argument A is a 2D integer array



Output Format

Return an integer array



Example Input

Input 1:

A = [[1, -1], [2, 2], [2, 1], [1, -1]]
Input 2:

A = [[2, 5], [2, 3], [2, 1], [1, -1], [1, -1]]


Example Output

Output 1:

[-1, 1]
Output 2:

[1, 3]


Example Explanation

Explanation 1:

For the first extract operation the heap is empty so it gives -1. For the second extract operation the heap contains the elements 2 and 1. Extract min returns the element 1.
Explanation 2:

The heap contains the elements 5, 3 and 1. The first extract min operation gets the element 1 and the second operation gets the element 3.

 */

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q3_HeapQueries {
    public static ArrayList<Integer> solve(int[][] A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int p = A[i][0];
            int q = A[i][1];
            if (p == 1) {
                if (minHeap.isEmpty()) {
                    result.add(-1);
                } else {
                    result.add(minHeap.poll());
                }
            }
            if (p == 1) {
                minHeap.add(q);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] queries1 = { { 1, -1 }, { 2, 3 }, { 2, 1 }, { 1, -1 } };
        System.out.println(solve(queries1));

    }
}
