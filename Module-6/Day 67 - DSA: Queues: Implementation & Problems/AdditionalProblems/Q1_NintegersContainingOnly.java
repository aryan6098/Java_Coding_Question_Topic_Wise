/*
 * Q1. N integers containing only 1, 2 & 3
Problem Description
Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.

NOTE: All the A integers will fit in 32-bit integers.



Problem Constraints
1 <= A <= 29500



Input Format
The only argument given is integer A.


Output Format
Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.


Example Input
Input 1:

 A = 3
Input 2:

 A = 7


Example Output
Output 1:

 [1, 2, 3]
Output 2:

 [1, 2, 3, 11, 12, 13, 21]


Example Explanation
Explanation 1:

 Output denotes the first 3 integers that contains only digits 1, 2 and 3.
Explanation 2:

 Output denotes the first 7 integers that contains only digits 1, 2 and 3.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q1_NintegersContainingOnly {

    public static ArrayList<Integer> solve(int A) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        int i = 3;
        while(arrayList.size() < A) {
            int val = queue.peek();
            arrayList.add(val);
            queue.remove();
            if(i >= A) {
                continue;
            }
            int a = val * 10 + 1;
            int b = val * 10 + 2;
            int c = val * 10 + 3;
            queue.add(a);
            queue.add(b);
            queue.add(c);
            i+= 3;
        }
        
        return arrayList;
    }

    public static void main(String[] args) {
        System.out.println(solve(7));
    }

}
