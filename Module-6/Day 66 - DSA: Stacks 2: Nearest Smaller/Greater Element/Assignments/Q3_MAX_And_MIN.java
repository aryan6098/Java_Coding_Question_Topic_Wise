/*
 * Q3. MAX and MIN
Problem Description
Given an array of integers A.

The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.


Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 1000000


Input Format
The first and only argument given is the integer array A.


Output Format
Return the sum of values of all possible subarrays of A modulo 109+7.


Example Input
Input 1:

 A = [1]
Input 2:

 A = [4, 7, 3, 8]


Example Output
Output 1:

 0
Output 2:

 26


Example Explanation
Explanation 1:

Only 1 subarray exists. Its value is 0.
Explanation 2:

value ( [4] ) = 4 - 4 = 0
value ( [7] ) = 7 - 7 = 0
value ( [3] ) = 3 - 3 = 0
value ( [8] ) = 8 - 8 = 0
value ( [4, 7] ) = 7 - 4 = 3
value ( [7, 3] ) = 7 - 3 = 4
value ( [3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3] ) = 7 - 3 = 4
value ( [7, 3, 8] ) = 8 - 3 = 5
value ( [4, 7, 3, 8] ) = 8 - 3 = 5
sum of values % 10^9+7 = 26

 */

import java.util.Stack;

public class Q3_MAX_And_MIN {
    static int mod = 1000000007;

    public static int[] nextSmallerLeftSide(int[] A) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[A.length];
        st.push(0);
        res[0] = -1;
        for (int i = 1; i < A.length; i++) {
            while (!st.empty() && A[i] <= A[st.peek()]) {
                st.pop();
            }
            if (st.empty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }

    public static int[] nextSmallerRightSide(int[] A) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            while (!st.empty() && A[i] <= A[st.peek()]) {
                st.pop();
            }
            if (st.empty()) {
                res[i] = A.length;
            } else {
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }

    public static int[] nextGreaterRightSide(int[] A) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[A.length];
        for (int i = A.length - 1; i >= 0; i--) {
            while (!st.empty() && A[i] >= A[st.peek()]) {
                st.pop();
            }
            if (st.empty()) {
                res[i] = A.length;
            } else {
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }

    public static int[] nextGreaterLeftSide(int[] A) {
       Stack<Integer> st = new Stack<>();
        int[] res = new int[A.length];
        st.push(0);
        res[0] = -1;
        for (int i = 1; i < A.length; i++) {
            while (!st.empty() && A[i] >= A[st.peek()]) {
                st.pop();
            }
            if (st.empty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }

    public static int solve(int[] A) {
        long sum = 0;
        int[] Left_Sum_MIN = nextSmallerLeftSide(A);
        int[] RIGHT_SUM_MIN = nextSmallerRightSide(A);
        int[] Left_Sum_MAX = nextGreaterLeftSide(A);
        int[] RIGHT_SUM_MAX = nextGreaterRightSide(A);
        for(int i = 0; i < A.length; i++) {
            long f1 = (long) A[i] * (i - Left_Sum_MAX[i]) * (RIGHT_SUM_MAX[i] - i);
            long f2 = (long) A[i] * (i - Left_Sum_MIN[i]) * (RIGHT_SUM_MIN[i] - i);
            sum = (sum + f1 - f2 + mod) % mod;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        int[] A = {4, 7, 3, 8};
        int res = solve(A);
        System.out.println(res);
        // for(int i = 0;i<res.length;i++){
        //     System.out.print(res[i] + " ");
        // }
    }
}
