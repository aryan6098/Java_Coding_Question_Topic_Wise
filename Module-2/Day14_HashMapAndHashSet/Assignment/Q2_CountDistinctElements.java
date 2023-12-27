/*
Q2. Count distinct elements

Problem Description
Given an array A of N integers, return the number of unique elements in the array.


Problem Constraints
1 <= N <= 105
1 <= A[i] <= 109


Input Format
First argument A is an array of integers.

Output Format
Return an integer.

Example Input
Input 1:
A = [3, 4, 3, 6, 6]
Input 2:
A = [3, 3, 3, 9, 0, 1, 0]

Example Output
Output 1:
3
Output 2:
4

Example Explanation
For Input 1:
The distinct elements of the array are 3, 4 and 6.
For Input 2:
The distinct elements of the array are 3, 9, 0 and 1.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Q2_CountDistinctElements {

     public static int solve(ArrayList<Integer> A) {
        HashSet<Integer> hashSet = new HashSet<>(A);
        return hashSet.size();
     }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(3,4,5,5,6,6,3,2,1));
        System.out.println(solve(arrayList));
    }
}
