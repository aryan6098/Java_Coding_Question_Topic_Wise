/*
 * Q3. Delete one
Problem Description
Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.

Find the maximum value of GCD.


Problem Constraints
2 <= N <= 105
1 <= A[i] <= 109


Input Format
First argument is an integer array A.


Output Format
Return an integer denoting the maximum value of GCD.

Example Input
Input 1:

 A = [12, 15, 18]
Input 2:

 A = [5, 15, 30]


Example Output
Output 1:

 6
Output 2:

 15


Example Explanation
Explanation 1:

 If you delete 12, gcd will be 3.
 If you delete 15, gcd will be 6.
 If you delete 18, gcd will 3.
 Maximum value of gcd is 6.
Explanation 2:

 If you delete 5, gcd will be 15.
 If you delete 15, gcd will be 5.
 If you delete 30, gcd will be 5.
 Maximum value of gcd is 15.
 */
public class Q3_DeleteOne {

    public static int gcd(int A, int B) {
        if(B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }

    // bruit force Approach
    // T.C -> O(N^2)  S.C -> (1)
    public static int solve(int[] A) {
        int ans = 0;
        for(int  i = 0; i < A.length; i++) {
            for(int j = i + 1; j < A.length; j++) {
                int currentGcd = gcd(A[i], A[j]);
                ans = Math.max(ans,gcd(A[i], A[j]));  
                if(currentGcd == 1){
                    return ans;
                }
            }
        }
        return ans;
    }


    public static int[] pfGCD(int[] A) {
        int ans = 0;
        int[] arr = new int[A.length];
        for(int i = 0 ; i < A.length; i++) {
            ans = gcd(ans, A[i]);
            arr[i] = ans;
        }

        return arr;
    }

    public static int[] sfGCD(int[] A) {
        int ans = 0; 
        int[] arr = new int[A.length];
        for(int i = A.length - 1; i >= 0; i--) {
            ans = gcd(ans, A[i]);
            arr[i] = ans;
        }
        return arr;
    }

    // Optimize solution using prefix array
    public static int solveMEthod1(int[] A) {
        int[] pfGCD = pfGCD(A);
        int[] sfGCD = sfGCD(A);
        int ans = 0;
        for(int i = 0; i < A.length; i++) {
            int left = 0;
            if(i > 0) {
                left  = pfGCD[i - 1];
            }
            int right = 0;
            if(i < A.length - 1) {
                right = sfGCD[i + 1];
            }
            int val = gcd(left, right);
            ans = Math.max(ans, val);
        }
        return ans;
    }



    public static void main(String[] args) {
        int arr[] = {5, 15, 30};
        System.out.println(solve(arr));
        System.out.println(solveMEthod1(arr));
    }
    
}
