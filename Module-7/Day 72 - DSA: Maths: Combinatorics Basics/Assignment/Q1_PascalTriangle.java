/*
 * Q1. Pascal Triangle
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
public class Q1_PascalTriangle {

    public static int[][] solve(int A) {
        int[][] C = new int[A + 1][A + 1];
        System.out.println("1 ");
        C[0][0] = 1;
        for(int i = 1; i < A; i++ ) {
            C[i][0] = 1;
            C[i][i] = 1;
            System.out.print(C[i][0]+" ");
            for(int j = 1; j < i ; j++) {
                C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
                System.out.print(C[i][j]+ " ");
            }
            System.out.println(C[i][i]+ " ");
        }
        return C;
    }

    public static void main(String[] args) {
        int[][] res = solve(5);
        for(int i = 0; i < 5; i++) {
            for(int j = 0 ; j < 5; j++) {
                System.out.print(res[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
