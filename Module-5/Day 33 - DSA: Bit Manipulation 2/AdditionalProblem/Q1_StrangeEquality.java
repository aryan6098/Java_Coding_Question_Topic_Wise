/*
 * Q1. Strange Equality
Problem Description
Given an integer A.
Two numbers, X and Y, are defined as follows:

X is the greatest number smaller than A such that the XOR sum of X and A is the same as the sum of X and A.
Y is the smallest number greater than A, such that the XOR sum of Y and A is the same as the sum of Y and A.
Find and return the XOR of X and Y.

NOTE 1: XOR of X and Y is defined as X ^ Y where '^' is the BITWISE XOR operator.

NOTE 2: Your code will be run against a maximum of 100000 Test Cases.


Problem Constraints
1 <= A <= 109


Input Format
First and only argument is an integer A.


Output Format
Return an integer denoting the XOR of X and Y.


Example Input
A = 5


Example Output
10


Example Explanation
The value of X will be 2 and the value of Y will be 8. The XOR of 2 and 8 is 10.
 */
public class Q1_StrangeEquality {

    public static int toggle(int n) {
        int temp = 1;
        while (temp <= n) {
            n = n ^ temp;
            temp = temp << 1;
        }
        return n;
    }

    public static int solve(int A) {
        int n = A;
        int count = 0;
        while (A > 0) {
            count++;
            A = A / 2;
        }

        int y = (1 << count);
        int x = toggle(n);
        System.out.println(x + " " + y);
        return x ^ y;

    }

    public static void main(String[] args) {
        System.out.println(solve(5));
    }
}
