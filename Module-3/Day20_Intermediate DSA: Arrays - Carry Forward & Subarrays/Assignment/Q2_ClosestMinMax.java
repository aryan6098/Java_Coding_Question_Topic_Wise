/*
 * Q2. Closest MinMax
Problem Description
Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array

and at least one occurrence of the minimum value of the array.


Problem Constraints
1 <= |A| <= 2000


Input Format
First and only argument is vector A


Output Format
Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array


Example Input
Input 1:
A = [1, 3, 2]

Input 2:
A = [2, 6, 1, 6, 9]

Example Output
Output 1:
2

Output 2:
3


Example Explanation
Explanation 1:

 Take the 1st and 2nd elements as they are the minimum and maximum elements respectievly.
Explanation 2:

 Take the last 3 elements of the array.
 */

public class Q2_ClosestMinMax {


    // 1st Approach  (Bruitforce Approach)  
    // T. C -> O(N^2) 
    // S.C -> O(1)
    public static int solve(int[] A) {
        int ans = A.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = A.length;
        for(int i = 0; i < A.length ;i++){
            if(A[i] > max) {
                max = A[i];
            }if(A[i] < min) {
                min = A[i];
            }
        }
        if(min == max) {
            return 1;
        }
        for(int i = 0 ;i < n; i++){
            if(A[i] == min) {
                for(int j = i + 1; j < n; j++){
                    if(A[j] == max) {
                        ans = Math.min(ans, j - i + 1);
                        break;
                    }
                }
            }
            if(A[i] == max) {
                for(int j = i +1; j < n; j++){
                    if(A[j] == min) {
                        ans = Math.min(ans, j - i + 1);
                        break;
                    }
                }
            }
        }
        return ans;
    } 

    // 2nd Approach
    // T. C -> O(N) 
    // S.C -> O(1)
    public static int closestMinMaxLHStoRHS(int A[]) { 
        int ans = A.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int n = A.length;
        for(int i = 0; i < A.length ;i++){
            if(A[i] > max) {
                max = A[i];
            }if(A[i] < min) {
                min = A[i];
            }
        }
        if(min == max) {
            return 1;
        }
        int minIndex = -1;
        int maxIndex = -1;

        for(int i = 0; i < A.length; i++){
            if(A[i] == min) {
                minIndex = i;
                if(maxIndex!= -1){
                    ans = Math.min(ans, minIndex - maxIndex + 1);
                }
            }
            if(A[i] == max){
                maxIndex = i;
                if(minIndex!= -1) {
                ans = Math.min(ans, maxIndex - minIndex + 1);
                }
            }
        }
        return ans;
    }

    // 2nd Approach
    // T. C -> O(N) 
    // S.C -> O(1)
    public static int closestMinMaxRHStoLHS(int A[]) { 
        int ans = A.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < A.length ;i++){
            if(A[i] > max) {
                max = A[i];
            }if(A[i] < min) {
                min = A[i];
            }
        }
        if(min == max) {
            return 1;
        }
        int minIndex = -1;
        int maxIndex = -1;

        for(int i = A.length-1 ; i >= 0 ;i--){
            if(A[i] == min) {
                minIndex = i;
                if(maxIndex!= -1){
                    ans = Math.min(ans, maxIndex - minIndex + 1);
                }
            }
            if(A[i] == max){
                maxIndex = i;
                if(minIndex!= -1) {
                ans = Math.min(ans, minIndex - maxIndex + 1);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {377,448,173,307,108};
       System.out.println( solve(arr));
       System.out.println(closestMinMaxLHStoRHS(arr));
       System.out.println(closestMinMaxRHStoLHS(arr));
    }
}
