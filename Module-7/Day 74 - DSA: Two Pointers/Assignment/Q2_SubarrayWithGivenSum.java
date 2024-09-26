/*
 * Q2. Subarray with given sum
Problem Description

Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.



Problem Constraints

1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109


Input Format

The first argument given is the integer array A.

The second argument given is integer B.


Output Format

Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".


Example Input

Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output

Output 1:

 [2, 3]
Output 2:

 [-1]


Example Explanation

Explanation 1:

 [2, 3] sums up to 5.
Explanation 2:

 No subarray sums up to required number.

 */
public class Q2_SubarrayWithGivenSum {
    public static int[] solve(int[] A, int B) {
       

        int sum = A[0];
        int i = 0;
        int j = 0;
        boolean isSubArray = false;
        while (j < A.length) {

            if (sum == B) {
                int[] res = new int[j - i + 1];
                int index = 0;
                for(int k = i; k <= j; k++) {
                    res[index++] = A[k];
                }
                return res;
            }
            if (sum < B) {
                j++;
                if (j == A.length) {
                    break;
                }
                sum = sum + A[j];
            } else if (sum > B) {
                sum = sum - A[i];
                i++;
            }
        }
        return new int[] { -1 };

    }

    public static void main(String[] args) {
        int[] A = { 1, 4, 3};
        int[] res = solve(A, 3);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }

    }
}
