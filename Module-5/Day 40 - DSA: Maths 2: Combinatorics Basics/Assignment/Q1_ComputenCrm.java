/*
 * Q1. Compute nCr % m
 * 
 * Problem Description
Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.

x! means factorial of x i.e. x! = 1 * 2 * 3... * x.


Problem Constraints
1 <= A * B <= 106

1 <= B <= A

1 <= C <= 106


Input Format
The first argument given is integer A ( = n).
The second argument given is integer B ( = r).
The third argument given is integer C ( = m).


Output Format
Return the value of nCr % m.


Example Input
Input 1:

 A = 5
 B = 2
 C = 13
Input 2:

 A = 6
 B = 2
 C = 13


Example Output
Output 1:

 10
Output 2:

 2


Example Explanation
Explanation 1:

 The value of 5C2 % 11 is 10.
Explanation 2:

 The value of 6C2 % 13 is 2.

 */
public class Q1_ComputenCrm {

    public static long fact(int n) {
        if(n == 0 ) {
            return 1;
        }
        return fact(n - 1) * n;
    }

    // public static int solve(int A, int B, int C) {
    //     long nFact = fact(A);
    //     int n_r_fact = fact(A - B);
    //     int rFact = fact(B);

    //     int nCr = (int)nFact/(n_r_fact * rFact);
    //     System.out.println(n_r_fact+ " " +" "+ rFact+ " "+ nFact + " " + nCr);
    //     return nCr % C;
    // }
        public static int solve(int A, int B, int C) {
            int[][] arr = new int [A + 1][B + 1];
            for(int i = 0; i <= A; i++) {
                for(int j = 0; j <= Math.min(i, B); j++) {
                    if(j == 0|| j == i) {
                        arr[i][j] = 1;
                    }
                    else {
                        arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j]) % C;
                    }
                }
            }
            return arr[A][B] % C;
        }
    public static void main(String[] args) {
        System.out.println(solve(38, 5, 81));
    }
}
