/*
 * Q1. Compute nCr % m
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
