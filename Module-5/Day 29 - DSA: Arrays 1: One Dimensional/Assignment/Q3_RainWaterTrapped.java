/*
 * Q3. Rain Water Trapped
Problem Description
Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.



Problem Constraints
1 <= |A| <= 100000



Input Format
First and only argument is the vector A

Output Format
Return one integer, the answer to the question

Example Input
Input 1:

A = [0, 1, 0, 2]
Input 2:

A = [1, 2]


Example Output
Output 1:
1

Output 2:
0

Example Explanation
Explanation 1:
1 unit is trapped on top of the 3rd element.

Explanation 2:
No water is trapped.

 */
public class Q3_RainWaterTrapped {
    public static int trap(final int[] A) {
        int[] leftMax = new int[A.length];
        int[] rightMax = new int[A.length];
        leftMax[0] = A[0];
        int sum = 0;
        rightMax[A.length - 1] = A[A.length - 1];
        for(int  i = 1; i < A.length; i++) {
            leftMax[i]=  Math.max(A[i], leftMax[i - 1]);
        }
        for(int  i = A.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(A[i], rightMax[i + 1]);
        }

        for(int i = 0; i < A.length; i++) {
            int min =  Math.min(leftMax[i], rightMax[i]);
            sum =sum + min - A[i];
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] arr = {4,2,0,3,2,5};
       System.out.println( trap(arr));
    }
}
