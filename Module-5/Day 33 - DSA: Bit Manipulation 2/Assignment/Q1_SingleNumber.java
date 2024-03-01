/*
 * Q1. Single Number
Problem Description
Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.

NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


Problem Constraints
1 <= |A| <= 2000000

0 <= A[i] <= INTMAX


Input Format
The first and only argument of input contains an integer array A.


Output Format
Return a single integer denoting the single element.


Example Input
Input 1:

 A = [1, 2, 2, 3, 1]
Input 2:

 A = [1, 2, 2]


Example Output
Output 1:
 3

Output 2:
 1
 */

import java.util.Arrays;

public class Q1_SingleNumber {

    public static int singleNumberMethod1(final int[] A) {
        int ans = 0;
        for(int i = 0; i < A.length; i++) {
            ans = ans ^ A[i];
        }
        return ans;
    }

    public static int singleNumberMethod2(final int[] A) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int count = 0;
            for(int  j = 0; j < A.length; j++) {
                if((A[j] & (1 << i)) > 0) {
                    count++;
                }
                
            }
            if((count & 1 )> 0) {
                ans = ans | (1 << i);
            }
        }
        return ans;
    }

    public static int singleNumberMethod3(final int[] A) {
        for(int i = 0; i < A.length; i++) {
            int count =0;
            int el = A[i];
            for(int j = 0; j < A.length; j++) {
                if( A[j] == el) {
                    count++;
                }
            }
            if(count == 1) {
                return A[i];
            }
        }
        return 0;
    }

    public static int singleNumberMethod4(final int[] A) { 
        Arrays.sort(A);
        for(int i = 0; i < A.length - 1; i += 2) {
            if(A[i] != A[i + 1]) {
                return A[i];
            }
        }
        return A[A.length - 1];
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 1};
        System.out.println(singleNumberMethod1(arr));
        System.out.println(singleNumberMethod2(arr));
       System.out.println(singleNumberMethod3(arr));
       System.out.println(singleNumberMethod4(arr));
    }
}
