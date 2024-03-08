/*
 * Q4. Sub-array with 0 sum
Problem Description
Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.

If the given array contains a sub-array with sum zero return 1, else return 0.



Problem Constraints
1 <= |A| <= 100000

-10^9 <= A[i] <= 10^9



Input Format
The only argument given is the integer array A.



Output Format
Return whether the given array contains a subarray with a sum equal to 0.



Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
Input 2:

 A = [4, -1, 1]


Example Output
Output 1:

 0
Output 2:

 1


Example Explanation
Explanation 1:

 No subarray has sum 0.
Explanation 2:

 The subarray [-1, 1] has sum 0.
 */
import java.util.HashSet;

public class Q4_SubArrayWith0Sum {

    public static int solve(int[] A) {
        Long[] pfSum = new Long[A.length];
        pfSum[0] =(long) A[0];
        for(int i = 1; i < A.length; i++) {
            pfSum[i] = A[i] + pfSum[i - 1];
        }

        HashSet<Long> hashSet = new HashSet<>();
        hashSet.add(0l);
        for(int i = 0 ; i < A.length; i++) {
            if(hashSet.contains(pfSum[i]) == true) {
                return 1;
            }
            hashSet.add(pfSum[i]);
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] array = {4, -1, 1};
        System.out.println(solve(array));
    }
}
