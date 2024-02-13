/*
 * Q2. Min XOR value
Problem Description
Given an integer array A of N integers, find the pair of integers in the array which have minimum XOR value. Report the minimum XOR value.



Problem Constraints
2 <= length of the array <= 100000
0 <= A[i] <= 109


Input Format
First and only argument of input contains an integer array A.


Output Format
Return a single integer denoting minimum xor value.


Example Input
Input 1:

 A = [0, 2, 5, 7]
Input 2:

 A = [0, 4, 7, 9]


Example Output
Output 1:
2

Output 2:
3


Example Explanation
Explanation 1:

 0 xor 2 = 2
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q2_MinXORValue {
    public static int findMinXor(ArrayList<Integer> A) {
        int min = (A.get(0)^A.get(1)); 
        for(int i = 0; i < A.size(); i++) {
            for(int j = i + 1; j <A.size(); j++) {
               if(min > (A.get(i) ^ A.get(j))) {
                min = (A.get(i)^A.get(j));
               }
            }
        }
        return min;
    }

    public static int findMinXorMethod1(ArrayList<Integer> A) {
        // Arrays.sort(A);
        Collections.sort(A);
        int minXOR = Integer.MAX_VALUE;

        for (int i = 0; i < A.size() - 1; i++) {
            int currentXOR = A.get(i) ^ A.get(i + 1);
            minXOR = Math.min(minXOR, currentXOR);
        }
        return minXOR;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(0, 4, 7, 9));
        System.out.println(findMinXorMethod1(arrayList));
    }
}
