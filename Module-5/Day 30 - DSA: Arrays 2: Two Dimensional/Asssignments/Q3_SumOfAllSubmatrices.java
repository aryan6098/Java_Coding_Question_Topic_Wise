public class Q3_SumOfAllSubmatrices {
    public static int solve(int[][] A) {
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                int contribution =  (i+1) * (j+1) * (A.length - i) * (A[0].length - j);
                sum += A[i][j] * contribution;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] A = {
            {1, 2},
            {3, 4}
        };
        System.out.println(solve(A));
    }
}
