/*
 * Q1. Maximum Subarray Easy
Problem Description
You are given an integer array C of size A. Now you need to find a subarray (contiguous elements) so that the sum of contiguous elements is maximum.
But the sum must not exceed B.


Problem Constraints
1 <= A <= 103
1 <= B <= 109
1 <= C[i] <= 106


Input Format
The first argument is the integer A.
The second argument is the integer B.
The third argument is the integer array C.


Output Format
Return a single integer which denotes the maximum sum.


Example Input
Input 1:
A = 5
B = 12
C = [2, 1, 3, 4, 5]
Input 2:

A = 3
B = 1
C = [2, 2, 2]


Example Output
Output 1:
12
Output 2:
0


Example Explanation
Explanation 1:
We can select {3,4,5} which sums up to 12 which is the maximum possible sum.

Explanation 2:
All elements are greater than B, which means we cannot select any subarray.
Hence, the answer is 0.

 */


public class Q1_MaximumSubarrayEasy {

    public static int maxSubarrayMethod3(int A, int B, int C[]) {
        int maxSum =0 ;
        for(int i = 0; i < A; i++) {
            int sum = 0;
            for(int j = i; j < A; j++) {
                sum = sum + C[j];
                if(sum > maxSum && sum <= B) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    public static int maxSubarrayMethod2(int A, int B, int C[]) {
        int[] prefixSum = new int[A];
        prefixSum[0] = C[0];
        int maxSum =0 ;
        for(int i = 1; i < A; i++){
            prefixSum[i] = prefixSum[i - 1] + C[i];
        }
        for(int i = 0; i < A; i++) {
            int sum = 0;
            for(int j = i; j < A; j++) {
                if(i == 0) {
                    sum = prefixSum[j];
                }
                else { 
                    sum = prefixSum[j]  - prefixSum[i - 1];
                }
                if(sum > maxSum && sum <= B) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    public static int maxSubarrayMethod1(int A, int B, int C[]) {
        int maxSum = 0;
        for(int i = 0; i < A; i++){
            
            for(int j = i; j < A; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++){ 
                    sum = sum + C[k];
                }
                if(sum > maxSum && sum <= B) {
                    maxSum = sum;
                }
            }
           
        }
        return maxSum;
    }

    
    
    

    public static void main(String[] args) {
        int C[] = {2, 1, 3, 4, 5};
        int A = 5;
        int B = 12;
        // maxSubarray(A, B, C);
        System.out.println(maxSubarrayMethod1(A, B, C));
        System.out.println(maxSubarrayMethod2(A, B, C));

        System.out.println(maxSubarrayMethod3(A, B, C));


        int C1[] = {2, 2, 2};
        int A1 = 3;
        int B1 = 1;
        // maxSubarray(A, B, C);
        // System.out.println(maxSubarrayMethod2(A1, B1, C1));
    } 
    
}
