/*
 * Q4. Mod Sum
Problem Description
Given an array of integers A, calculate the sum of A [ i ] % A [ j ] for all possible i, j pairs. Return sum % (109 + 7) as an output.



Problem Constraints
1 <= length of the array A <= 105

1 <= A[i] <= 103


Input Format
The only argument given is the integer array A.


Output Format
Return a single integer denoting sum % (109 + 7).


Example Input
Input 1:

 A = [1, 2, 3]
Input 2:

 A = [17, 100, 11]


Example Output
Output 1:

 5
Output 2:

 61


Example Explanation
Explanation 1:

 (1 % 1) + (1 % 2) + (1 % 3) + (2 % 1) + (2 % 2) + (2 % 3) + (3 % 1) + (3 % 2) + (3 % 3) = 5

 */
public class Q4_ModSum {

    public static int solve(int[] A) {

        int modValue = 1000000007; // (10^9 + 7)
        int n = A.length;
        int resultSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultSum = (resultSum + A[i] % A[j]) % modValue;
            }
        }

        return resultSum;
    }

    public static int solveMethod1(int[] A) {
        int mod = 1000000007;
        int[] count = new int[1001];
        for (int i = 0; i < A.length; i++) {
            count[A[i]]++;

        } 
        int ans = 0;
        for(int i = 1; i < count.length; i++) {
            for(int j = 1; j < count.length; j++) {
                int val = i % j;
                int temp = count[i] * count[j] * val;
                ans = ((ans % mod) + (temp % mod)) % mod;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        System.out.println(solve(arr));
        System.out.println(solveMethod1(arr));
    }
}
