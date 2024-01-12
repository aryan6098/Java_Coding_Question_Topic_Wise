/*
 * Q3. Subarray with given sum and length
Problem Description
Given an array A of length N. Also given are integers B and C.

Return 1 if there exists a subarray with length B having sum C and 0 otherwise

Problem Constraints
1 <= N <= 105

1 <= A[i] <= 104

1 <= B <= N

1 <= C <= 109



Input Format
First argument A is an array of integers.

The remaining arguments B and C are integers

Output Format
Return 1 if such a subarray exist and 0 otherwise

Example Input
Input 1:
A = [4, 3, 2, 6, 1]
B = 3
C = 11
Input 2:

A = [4, 2, 2, 5, 1]
B = 4
C = 6


Example Output
Output 1:
1

Output 2:
0


Example Explanation
Explanation 1:
The subarray [3, 2, 6] is of length 3 and sum 11.
Explanation 2:
There are no such subarray.
 */
public class Q3_SubarrayWithGivenSumAndLength {


    public static int method3(int[] A, int B, int C){
        int sum = 0;
        int result = 0;
        for(int i = 0; i < B; i++){
            sum = sum + A[i];
        }
        if(sum == C) {
            return 1;
        }
        int st = 1;
        int end = B;
        while (end < A.length) {
            sum = sum - A[st -1] + A[end];
            if(sum == C) {
                return 1;
            }
            st++;
            end++;
        }
        return 0;
    }

    public static int method1(int[] A, int B, int C){
        int[] prefixSum = new int[A.length];
        prefixSum[0] = A[0];
        for(int i = 1; i < A.length; i++){
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        int st = 0;
        int end = B - 1;
        while (end < A.length) {
            int sum = 0;
            if(st == 0){
                sum += prefixSum[end];
            }
            else {
                sum += prefixSum[end] - prefixSum[st -1];
            }
            if(sum== C) {
                return 1;
            }
             st++;
            end++;
        }
        return 0;
    }
    public static int solve(int[] A, int B, int C) {
        int ans = 0;
        int st = 0;
        int end = B-1;
        int max = 0;
        while(end < A.length){
            int sum = 0;
            for(int i = st; i <= end; i++){
                sum = sum + A[i];
            }
            if(sum == C) {
                return 1;
            }
            st++;
            end++;
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6, 1};
        System.out.println(solve(arr, 3, 11));
        System.out.println(method1(arr, 3, 11));
        System.out.println(method3(arr, 3, 11));
    }
    
}
