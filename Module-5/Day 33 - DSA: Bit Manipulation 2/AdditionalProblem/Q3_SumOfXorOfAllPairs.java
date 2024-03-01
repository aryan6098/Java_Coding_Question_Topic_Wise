/*
 * Q3. Sum of Xor of all Pairs
Problem Description
Given an array A of N integers. Find the sum of bitwise XOR all pairs of numbers in the array.

Since the answer can be large, return the remainder after the dividing the answer by 109+7.


Problem Constraints
1 <= N <= 105

1 <= A[i] < 109


Input Format
Only argument A is an array of integers


Output Format
Return an integer denoting the sum of xor of all pairs of number in the array.


Example Input
Input 1:
A = [1, 2, 3]
Input 2:
A = [3, 4, 2]


Example Output
Output 1:
6
Output 2:
14


Example Explanation
For Input 1:
Pair    Xor
{1, 2}  3
{1, 3}  2
{2, 3}  1
Sum of xor of all pairs = 3 + 2 + 1 = 6.
For Input 2:
Pair    Xor
{3, 4}  7
{3, 2}  1
{4, 2}  6
Sum of xor of all pairs = 7 + 1 + 6 = 14.
 */
public class Q3_SumOfXorOfAllPairs {

    public static int solve(int[] A) {
        int ans = 0 ; 
        for(int  i = 0 ; i < A.length; i++) {
            for(int j = i + 1; j < A.length; j++) {
                ans += A[i] ^A[j];
            }
        }

        return ans;
    }

    public static int solveMethod1(int[] A) {
        long result = 0;
        int MOD = 1000000007;
        for(int i = 0; i < 31; i++) {
            long countSetBits = 0;
            long countUnsetBits = 0;
            for(int j = 0 ; j < A.length; j++) {
                if(((A[j] & (1 << i) )) != 0) {
                    countSetBits++;
                }
                else { 
                    countUnsetBits++;
                }
            }
            long contribution = (countSetBits * countUnsetBits) % MOD;
            result = (result + (contribution << i) % MOD) % MOD;
        }
        return (int) result;

    }
    public static void main(String[] args) {
        int[] arr = { 3, 4, 2};
        System.out.println(solveMethod1(arr));
    }
}
