/*
 * Q1. Max Sum Contiguous Subarray
Problem Description
Find the maximum sum of contiguous non-empty subarray within an array A of length N.


Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000


Input Format
The first and the only argument contains an integer array, A.

Output Format
Return an integer representing the maximum possible sum of the contiguous subarray.


Example Input
Input 1:
 A = [1, 2, 3, 4, -10] 

Input 2:
 A = [-2, 1, -3, 4, -1, 2, 1, -5, 4] 


Example Output
Output 1:
 10 

Output 2:
 6 

Example Explanation
Explanation 1:

 The subarray [1, 2, 3, 4] has the maximum possible sum of 10. 
Explanation 2:

 The subarray [4,-1,2,1] has the maximum possible sum of 6. 
 */
public class Q1_MaxSumContiguousSubarray {


    // Bruit Force Approach
    public static int maxSubArray(final int[] A) {

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            
            for(int j = i; j < A.length; j ++) 
            {
                int sum = 0;
                for(int k = i ; k  <= j; k++) {
                    sum = sum + A[k];
                }
                if(sum > ans) { 
                    ans = sum;
                }
            }
        }
        return ans;
    }

    //prefix Array Concept
    public static int maxSubArrayMethod1(final int[] A) {
        int ans = Integer.MIN_VALUE;
        int[] prefixSum = new int[A.length];
        prefixSum[0] = A[0];
        for(int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        for(int i = 0; i < A.length; i++) {
            int sum = 0;
            for(int j = i; j < A.length; j++) {
                if(i == 0) {
                    sum = prefixSum[j];
                }
                else {
                    sum = prefixSum[j] - prefixSum[ i - 1];
                }

                if(sum > ans) { 
                    ans = sum;
                }
            }
           
        }
        return ans;
    }

    //Carry forward Concept
    public static int maxSubArrayMethod2(final int[] A) { 
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < A.length; i++) {
            int sum = 0; 
            for(int j = i; j < A.length; j++) {
                sum = sum + A[j];
                if(sum > ans) { 
                    ans = sum;
                }
            }
        }
        return ans;
    }

    public static int maxSubArrayMethod3(final int[] A) { 
        int  ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ;i < A.length; i++) {
            sum = sum + A[i];
            if(sum > ans) {
                ans = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArrayMethod1(arr));
        System.out.println(maxSubArrayMethod2(arr));
        System.out.println(maxSubArrayMethod3(arr));
    }
}
