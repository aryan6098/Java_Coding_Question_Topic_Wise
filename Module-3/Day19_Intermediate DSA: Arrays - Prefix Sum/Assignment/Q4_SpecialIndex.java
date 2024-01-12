/*
 * Q4. Special Index
Problem Description
Given an array, arr[] of size N, the task is to find the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.


Problem Constraints
1 <= N <= 105
-105 <= A[i] <= 105
Sum of all elements of A <= 109


Input Format
First argument contains an array A of integers of size N


Output Format
Return the count of array indices such that removing an element from these indices makes the sum of even-indexed and odd-indexed array elements equal.



Example Input
Input 1:
A = [2, 1, 6, 4]
Input 2:

A = [1, 1, 1]


Example Output
Output 1:
1
Output 2:

3


Example Explanation
Explanation 1:
Removing arr[1] from the array modifies arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1]. 
Therefore, the required output is 1. 
Explanation 2:

Removing arr[0] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[1] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Removing arr[2] from the given array modifies arr[] to { 1, 1 } such that arr[0] = arr[1] 
Therefore, the required output is 3.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q4_SpecialIndex {

    // using ArrayList
    public static int solve(ArrayList<Integer> A) {
        int count = 0;
        ArrayList<Long> evenPrefixSum = new ArrayList<>();
        ArrayList<Long> oddPrefixSum = new ArrayList<>();
        evenPrefixSum.add((long)A.get(0));
        oddPrefixSum.add((long)0);
        for(int i = 1; i < A.size(); i++) {
            if(i%2 == 0) { 
                evenPrefixSum.add(evenPrefixSum.get(i - 1 ) + A.get(i));
                oddPrefixSum.add(oddPrefixSum.get(i - 1) + 0);
            }
            else{
                evenPrefixSum.add(evenPrefixSum.get(i - 1) + 0);
                oddPrefixSum.add(oddPrefixSum.get(i - 1) + A.get(i));
            }
        }
        int n = A.size()-1;
        for(int i = 0; i < A.size(); i++) {
            long evenSum = oddPrefixSum.get(n) - oddPrefixSum.get(i);
            long oddSum = evenPrefixSum.get(n) - evenPrefixSum.get(i);
            if(i > 0) {
                evenSum = evenSum + evenPrefixSum.get(i - 1);
                oddSum = oddSum + oddPrefixSum.get(i - 1);
            }
            if(evenSum == oddSum) {
                count++;
            }
        }
        return count;
    }



    // Using Array
    public static int solveUsingArray(int[] A) {

        long[] prefixOddSum = new long[A.length];
        long[] prefixEvenSum = new long[A.length];

        prefixEvenSum[0] = A[0];
        prefixOddSum[0] = 0;

        for(int i = 1; i < A.length; i++){
           if(i%2 == 0){
                prefixEvenSum[i] = prefixEvenSum[i-1] + A[i];
               prefixOddSum[i] = prefixOddSum[i-1] + 0;
           }else {
               prefixEvenSum[i] = prefixEvenSum[i-1] + 0;
               prefixOddSum[i] = prefixOddSum[i-1] + A[i];
           }
        }

        int count = 0;
        int n = A.length - 1;
        for(int i = 0; i < A.length; i++) {
            long evenSum = prefixOddSum[n] - prefixOddSum[i];
            long oddSum = prefixEvenSum[n] - prefixEvenSum[i];
            if(i > 0) {
                evenSum = evenSum + prefixEvenSum[i-1];
                oddSum = oddSum + prefixOddSum[i-1];
            }
            if(evenSum == oddSum) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(2, 1, 6, 4));
        System.out.println(solve(arrayList));
    }
}
