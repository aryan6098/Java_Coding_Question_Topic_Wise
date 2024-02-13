/*
 * Q4. Find Two Missing Numbers
 * Problem Description
Given an array A of length N where all the elements are distinct and are in the range [1, N+2].

Two numbers from the range [1, N+2] are missing from the array A. Find the two missing numbers.


Problem Constraints
1 <= N <= 105

1 <= A[i] <= N+2

The elements of array A are distinct


Input Format
Only argument A is an array of integers


Output Format
Return a sorted array of size 2 denoting the missing elements.


Example Input
Input 1:
A = [3, 2, 4]
Input 2:
A = [5, 1, 3, 6]

Example Output
Output 1:
[1, 5]
Output 2:
[2, 4]

Example Explanation
For Input 1:
The missing numbers are 1 and 5.
For Input 2:
The missing numbers are 2 and 4.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q4_FindTwoMissingNumbers {
    public static int[] solve(int[] A) {
        int n = A.length + 2;
        boolean mark[] = new boolean[n + 1];
        for (int i = 0; i < n - 2; i++) {
            mark[A[i]] = true;
        }

        int[] result = new int[2];
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (!mark[i]) {
                result[index++] = i;
            }
        }
        if(result[1] == 0) {
            result[1] = n;
        }
        return result;
    }

    public static void main(String[] args) {
        // ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 1, 3, 6));
        // solve(arrayList);
        int arr[] = {4,2,3,5}; 
        int[] result = solve(arr);
        for(int i  = 0; i < result.length; i++) {
            System.out.print(result[i] +" ");
        }

    }
}
