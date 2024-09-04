/*
 * Q1. Merge Two Sorted Arrays
Problem Description
Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output.

Note: A linear time complexity is expected and you should avoid use of any library function.


Problem Constraints
-2×109 <= A[i], B[i] <= 2×109
1 <= |A|, |B| <= 5×104


Input Format
First Argument is a 1-D array representing  A.
Second Argument is also a 1-D array representing B.


Output Format
Return a 1-D vector which you got after merging A and B.


Example Input
Input 1:

A = [4, 7, 9]
B = [2, 11, 19]
Input 2:

A = [1]
B = [2]


Example Output
Output 1:

[2, 4, 7, 9, 11, 19]
Output 2:

[1, 2]


Example Explanation
Explanation 1:

Merging A and B produces the output as described above.
Explanation 2:

 Merging A and B produces the output as described above.

 */
public class Q1_MergeTwoSortedArrays {

    public static int[] solve(final int[] A, final int[] B) {
        int[] ans = new int[A.length + B.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while(i < A.length && j < B.length) {
            if(A[i] < B[j]) {
                ans[index] = A[i];
                i++;
            }
            else {
                ans[index] = B[j];
                j++;
            }
            index++;
        }
        while (i < A.length) {
            ans[index] = A[i];
            i++;
            index++;
        }
        while(j < B.length) {
            ans[index] = B[j];
            j++;
            index++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {4, 7, 9};
        int[] B = {2, 11, 19};
        int[] res = solve(A, B);
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
