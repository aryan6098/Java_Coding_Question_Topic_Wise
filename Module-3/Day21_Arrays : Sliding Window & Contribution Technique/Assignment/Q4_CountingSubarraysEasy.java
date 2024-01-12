/*
 * Q4. Counting Subarrays Easy
Problem Description
Given an array A of N non-negative numbers and a non-negative number B,
you need to find the number of subarrays in A with a sum less than B.
We may assume that there is no overflow.


Problem Constraints
1 <= N <= 5 x 103

1 <= A[i] <= 1000

1 <= B <= 107


Input Format
First argument is an integer array A.

Second argument is an integer B.


Output Format
Return an integer denoting the number of subarrays in A having sum less than B.


Example Input
Input 1:

 A = [2, 5, 6]
 B = 10
Input 2:

 A = [1, 11, 2, 3, 15]
 B = 10


Example Output
Output 1:
 4
Output 2:
 4


Example Explanation
Explanation 1:

 The subarrays with sum less than B are {2}, {5}, {6} and {2, 5},
Explanation 2:

 The subarrays with sum less than B are {1}, {2}, {3} and {2, 3}
 */

public class Q4_CountingSubarraysEasy {

     public static int method2(int[] A, int B) {
        int count=0;
        for(int i = 0 ;i<A.length;i++){
            int sum = 0;
            for(int j =i; j < A.length; j++){
                sum += A[j];
                if(sum < B) {
                    count++;
                }
            }
        }
        return count;
     }

    public static int solve(int[] A, int B) {
        int prefixSum[] = new int[A.length];
        prefixSum[0] = A[0];
        int count=0;
        for(int i =1; i <A.length; i++){
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        for(int i = 0; i < A.length; i++) {
            for(int j = i; j < A.length ; j++){
                int sum = 0;
                if (i==0){
                    sum = sum + prefixSum[j];
                }
                else {
                    sum = prefixSum[j] - prefixSum[i-1];
                }
                if(sum < B) {
                    count ++;
                }
            }
           
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = {1, 11, 2, 3, 15};
        System.out.println(solve(arr, 10));
        System.out.println(method2(arr, 10));
    }
}
        