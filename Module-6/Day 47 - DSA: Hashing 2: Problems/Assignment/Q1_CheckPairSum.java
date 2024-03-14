/*
 * Problem Description
Given an Array of integers B, and a target sum A.
Check if there exists a pair (i,j) such that Bi + Bj = A and i!=j.


Problem Constraints
1 <= Length of array B <= 105
0 <= Bi <= 109
0 <= A <= 109


Input Format
First argument A is the Target sum, and second argument is the array B


Output Format
Return an integer value 1 if there exists such pair, else return 0.


Example Input
Input 1:

A = 8   
B = [3, 5, 1, 2, 1, 2]
Input 2:

A = 21   
B = [9, 10, 7, 10, 9, 1, 5, 1, 5]


Example Output
Output 1:

1
Output 2:

0


Example Explanation
Example 1:
It is possible to obtain sum 8 using 3 and 5.
Example 2:
There is no such pair exists.

 */
import java.util.HashSet;

public class Q1_CheckPairSum {

    public static int solve(int A, int[] B) {

        HashSet<Integer> hashSet = new HashSet<>();
        for(int i = 0; i < B.length; i++) {
            int x =  A - B[i];
            if(hashSet.contains(x)) {
                System.out.println(x +" " + " " +  B[i] +  " " + i);
                return 1;
            }
            else {
                hashSet.add(B[i]);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int A[] = {9, 10, 7, 10, 9, 1, 5, 1, 5};
        int B = 21;
        System.out.println(solve(B, A));
    }
}
