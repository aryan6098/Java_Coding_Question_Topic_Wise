/*
 * Given a mat[N][N] print boundary in clockwise direction
 */
public class PrintBoundryClockwise {
    public static void printBoundaryClockwise(int[][] A) {
        int n = A.length-1;
        int i = 0; int j = 0;

        // i = 0 , j = 0
        for(int k = 0; k <= n - 1; k++) {
            System.out.print(A[i][j]+ " ");
            j++;
        }

        //i = 0, j = 2
        for(int k = 0; k <= n - 1; k++) {
            System.out.print(A[i][j]+ " ");
            i++;
        }

        // i = 2 , j = 2
        for(int k = 0; k <= n - 1; k++) {
            System.out.print(A[i][j]+ " ");
            j--;
        }

        // i = 2, j = 0
        for(int k = 0; k <= n - 1; k++) {
            System.out.print(A[i][j]+ " ");
            i--;
        }

    }
    public static void main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        printBoundaryClockwise(A);
    }
}
