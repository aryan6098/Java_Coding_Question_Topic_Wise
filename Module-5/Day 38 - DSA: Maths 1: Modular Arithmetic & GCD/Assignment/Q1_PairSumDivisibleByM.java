/*
 * Q1. Pair Sum divisible by M
 * Problem Description
Given an array of integers A and an integer B, find and return the number of pairs in A whose sum is divisible by B.

Since the answer may be large, return the answer modulo (109 + 7).

Note: Ensure to handle integer overflow when performing the calculations.

Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 106


Input Format
The first argument given is the integer array A.
The second argument given is the integer B.


Output Format
Return the total number of pairs for which the sum is divisible by B modulo (109 + 7).


Example Input
Input 1:
 A = [1, 2, 3, 4, 5]
 B = 2

Input 2:
 A = [5, 17, 100, 11]
 B = 28


Example Output
Output 1:
 4

Output 2:
 1


Example Explanation
Explanation 1:
 All pairs which are divisible by 2 are (1,3), (1,5), (2,4), (3,5). 
 So total 4 pairs.
Explanation 2:
 There is only one pair which is divisible by 28 is (17, 11)
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q1_PairSumDivisibleByM {

    // Method 1
    public static int solve(ArrayList<Integer> A, int B) {
        int count = 0;
        for(int i = 0; i < A.size(); i++) {
            for(int j = i + 1; j < A.size(); j++) {
                if((A.get(i) + A.get(j)) % B == 0 && i != j) {
                    count++;
                }
            }
        }
        return count;
    }

    // Method 2
    public static int solveMethod1(int[] A, int B) {
        int[] freq = new int[B];
        for(int i = 0; i < A.length; i++) {
           int rem = (A[i] % B + B)%B;
           freq[rem]++;
        }
        int ans = 0;
            int x = freq[0];
            ans + = ((long) x * (x - 1)) / 2;

            if(B % 2 == 0) {
                int y = freq[B/2];
                ans +=  ((long) y * (y - 1)) /2;
            }

            int i = 1;
            int j = B - 1;

            while(i < j) {
                ans += ((long) freq[i] * freq[j]);
                i++;
                j--;
            }
            
        return (int) (ans % (1000000007));
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 17, 100, 11));

        int[] arr = {5, 17, 100, 11};
        System.out.println(solve(arrayList, 28));
        System.out.println(solveMethod1(arr, 28));
    }   
}
