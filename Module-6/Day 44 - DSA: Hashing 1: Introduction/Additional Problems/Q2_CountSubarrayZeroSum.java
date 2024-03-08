/*
 * Q2. Count Subarray Zero Sum
Problem Description
Given an array A of N integers.

Find the count of the subarrays in the array which sums to zero. Since the answer can be very large, return the remainder on dividing the result with 109+7


Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109


Input Format
Single argument which is an integer array A.


Output Format
Return an integer.


Example Input
Input 1:

 A = [1, -1, -2, 2]
Input 2:

 A = [-1, 2, -1]


Example Output
Output 1:
3

Output 2:
1


Example Explanation
Explanation 1:

 The subarrays with zero sum are [1, -1], [-2, 2] and [1, -1, -2, 2].
Explanation 2:

 The subarray with zero sum is [-1, 2, -1].
 */

import java.util.HashMap;

public class Q2_CountSubarrayZeroSum {

    public static int solve(int[] A) {

        int[] pfSum = new int[A.length];
        pfSum[0] = A[0];
        for(int i = 1; i < A.length; i++) {
            pfSum[i] = pfSum[i - 1] + A[i];
        }
        for(int i = 0 ; i  < pfSum.length; i++) {
            System.out.print(pfSum[i] +" ");
        }
        System.out.println("------------");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int ans = 0;
        for(int i  = 0; i < pfSum.length; i++) {
            if(hashMap.containsKey(pfSum[i]) == true) {
                ans = ans + hashMap.get(pfSum[i]);
                hashMap.put(pfSum[i], hashMap.get(pfSum[i]) + 1);
            }
            else {
                hashMap.put(pfSum[i], 1);
            }

        }

        
        return ans;
    }


    public static void main(String[] args) {
        int[] array = {1, -1 ,-2, 2};
        // {1, -1 ,-2, 2};
        System.out.println(solve(array));
    }
}
