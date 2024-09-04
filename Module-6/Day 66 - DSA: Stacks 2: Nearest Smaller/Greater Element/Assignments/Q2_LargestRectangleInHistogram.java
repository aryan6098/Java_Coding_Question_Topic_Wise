/*
 * Q2. Largest Rectangle in Histogram
Problem Description
Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.


Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 10000


Input Format
The only argument given is the integer array A.


Output Format
Return the area of the largest rectangle in the histogram.


Example Input
Input 1:

 A = [2, 1, 5, 6, 2, 3]
Input 2:

 A = [2]


Example Output
Output 1:

 10
Output 2:

 2


Example Explanation
Explanation 1:

The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
Explanation 2:

Largest rectangle has area 2.

 */

import java.util.Stack;

public class Q2_LargestRectangleInHistogram {

    public static int[] nextSmallerLeftSide(int[] A) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[A.length];
        st.push(0);
        res[0] = -1;
        for(int i = 1; i < A.length; i++) {
            while (!st.empty() && A[i] <= A[st.peek()]) {
                st.pop();
            }
            if(st.empty()) {
                res[i] = -1;
            }
            else {
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }


    public static int[] nextSmallerRightSide(int[] A) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[A.length];
        for(int i = A.length - 1; i >= 0; i--) {
            while(!st.empty() && A[i] <= A[st.peek()]) {
                st.pop();
            }
            if(st.empty()) {
                res[i] = -1;
            }else {
                res[i] = st.peek();
            }
            st.push(i);
        }
        return res;
    }

    public static int largestRectangleArea(int[] A) {
        int[] res_L = nextSmallerLeftSide(A);
        int[] res_R = nextSmallerRightSide(A);
        long maxArea = 1;
        for(int i = 0 ; i < A.length; i++) {
            int l = res_L[i];
            int r = res_R[i];
            int width = r - l - 1;
            long area = A[i] * width;
            if(area > maxArea) {
                maxArea = area;
            }
        }
        return (int)maxArea;
    }



    public static void main(String[] args) {
        int[] A = {2, 1, 5, 6, 2, 3};
        int[] res_L = nextSmallerLeftSide(A);
        int[] res_R = nextSmallerRightSide(A);
        for(int i = 0; i < res_L.length; i++) {
            System.out.print(res_L[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < res_R.length; i++) {
            System.out.print(res_R[i] + " ");
        }
        System.out.println(largestRectangleArea(A));
    }
}
