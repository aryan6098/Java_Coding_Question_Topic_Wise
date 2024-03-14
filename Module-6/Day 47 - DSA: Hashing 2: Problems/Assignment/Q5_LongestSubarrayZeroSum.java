/*
 * Problem Description
Given an array A of N integers.
Find the length of the longest subarray in the array which sums to zero.

If there is no subarray which sums to zero then return 0.


Problem Constraints
1 <= N <= 105
-109 <= A[i] <= 109


Input Format
Single argument which is an integer array A.


Output Format
Return an integer.


Example Input
Input 1:

 A = [1, -2, 1, 2]
Input 2:

 A = [3, 2, -1]


Example Output
Output 1:
3

Output 2:
0


Example Explanation
Explanation 1:

 [1, -2, 1] is the largest subarray which sums up to 0.
Explanation 2:

 No subarray sums up to 0.
 */
import java.util.HashMap;

public class Q5_LongestSubarrayZeroSum {
    public static int solve(int[] A) {

        long sum = 0;
        int maxLength = 0;
        HashMap<Long, Integer> hashMap = new HashMap<>();
        hashMap.put(0l, -1);
        for(int i =0; i < A.length; i++) {
            sum += A[i];
            if(hashMap.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - hashMap.get(sum));
            }
            else {
                hashMap.put(sum, i);
            }
        }
        return  maxLength;
    }

    public static void main(String[] args) {
        int[] A1 = {1, -2, 1, 2};
        int[] A2 = {3, 2, -1};
        
        System.out.println(solve(A1)); // Output: 3
        System.out.println(solve(A2)); // Output: 0
    }
}
