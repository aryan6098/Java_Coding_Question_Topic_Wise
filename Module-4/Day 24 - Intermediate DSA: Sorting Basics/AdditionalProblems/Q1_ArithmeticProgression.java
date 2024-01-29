/*
 * Q1. Arithmetic Progression?
Problem Description
Given an integer array A of size N. Return 1 if the array can be arranged to form an arithmetic progression, otherwise return 0.

A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.



Problem Constraints
2 <= N <= 105

-109 <= A[i] <= 109



Input Format
The first and only argument is an integer array A of size N.



Output Format
Return 1 if the array can be rearranged to form an arithmetic progression, otherwise return 0.

Example Input
Input 1:

 A = [3, 5, 1]
Input 2:

 A = [2, 4, 1]


Example Output
Output 1:

 1
Output 2:

 0


Example Explanation
Explanation 1:

 We can reorder the elements as [1, 3, 5] or [5, 3, 1] with differences 2 and -2 respectively, between each consecutive elements.
Explanation 2:

 There is no way to reorder the elements to obtain an arithmetic progression.
 */
import java.util.*;
public class Q1_ArithmeticProgression {
    public static int solve(int[] A) {
        Arrays.sort(A);
        int res = 0;
        int diff = 0;
        if(A.length == 1) {
            res = 1;
        }
        else if(A.length >=2) { 
            diff = A[1] - A[0];
        }
         
        for(int i = 1; i < A.length; i++) {
            if(A[i] - A[i-1] != diff) {
                res = 0;
                break ;
            }   
            else {
                res = 1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int arr[] = {};
        System.out.println(solve(arr));
    }
}
