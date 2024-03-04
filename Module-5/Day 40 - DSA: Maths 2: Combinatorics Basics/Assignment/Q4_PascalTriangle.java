/*
 * Q4. Pascal Triangle
Problem Description

Write a program to print the pascal triangle up to A rows.

Problem Constraints

1 <= A <= 25

Input Format

The first argument is an integer A.


Output Format

Return a 2D array consisting of A rows whose each row contains A integers.



Example Input

Input 1:
A = 3

Input 2:
A = 5

Example Output

Output 1:

1 0 0 
1 1 0 
1 2 1 

Output 2:

1 0 0 0 0
1 1 0 0 0
1 2 1 0 0
1 3 3 1 0
1 4 6 4 1 


Example Explanation

Explanation 1:

Row 1 = 1 0 0 
Row 2 = 1C0 1C1 0 = 1 1 0
Row 3 = 2C0 2C1 2C2 = 1 2 1
 */
public class Q4_PascalTriangle {

    public static long fact(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public static int[][] solve(int A) {
        int[][] res = new int[A][A];
        for (int i = 0; i < A; i++) {
            for (int j = 0; j <= i; j++) {
                long nFact = fact(i);
                long rFact = fact(j);
                long n_r_fact = fact(i - j);
                double ans = (double) (nFact / (rFact * n_r_fact));
                res[i][j] = (int) ans;
            }
        }
        return res;
    }

    public static int[][] solveMethod1(int A) {
        if (A <= 0) {
            return new int[0][0];
        }
        int[][] res = new int[A][A];
        res[0][0] = 1;
        for (int i = 1; i < A; i++) {
            res[i][0] = 1;
            res[i][i] = 1;
            for (int j = 1; j < i; j++) {
                res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        // int[][] res = solve(5);
        // for (int i = 0; i < res.length; i++) {
        // for (int j = 0; j < res[0].length; j++) {
        // System.out.print(res[i][j] + " ");
        // }
        // System.out.println();
        // }

        int[][] res = solveMethod1(5);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}
