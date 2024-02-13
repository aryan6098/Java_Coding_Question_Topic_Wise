/*
 * Given a mat A N print boundary in clockwise direction
 */
public class PrintSpiralMatrix {
    public static void printSpiralMatrix(int[][] A) {
        int n = A.length;
        int i = 0;
        int j = 0;
        int[][] result = new int[A.length][A[0].length];
        int count = 1;
        while (n > 0) {
            // Print top row from left to right
            for (int k = 0; k < n; k++) {
                result[i][j] = count;
                count++;
                System.out.print(A[i][j++] + " ");
            }
            i++; // Move to the next row
            j--; // Adjust j back to the last valid position

            // Print right column from top to bottom
            for (int k = 0; k < n - 1; k++) {
                result[i][j] = count;
                count++;
                System.out.print(A[i++][j] + " ");
            }
            i--; // Adjust i back to the last valid position
            j--; // Move to the previous column

            // Print bottom row from right to left
            for (int k = 0; k < n - 1; k++) {
                result[i][j] = count;
                count++;
                System.out.print(A[i][j--] + " ");
            }
            i--; // Move to the previous row
            j++; // Adjust j back to the last valid position

            // Print left column from bottom to top
            for (int k = 0; k < n - 2; k++) {
                result[i][j] = count;
                count++;
                System.out.print(A[i--][j] + " ");
            }
            i++; // Adjust i back to the last valid position
            j++; // Move to the next column

            n -= 2; // Reduce the size for the next iteration
        }

        // Print the center element if any
        if (n == 1) {
            result[i][j] = count;
                count++;
            System.out.print(A[i][j]);
        }

        System.out.println();
        for(int k = 0 ; k < result.length; k++) {
            for(int m = 0; m < result[0].length; m++) {
                System.out.print(result[k][m] +" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };

        int[][] arr = {
            {1, 2, 3, 4, 5, 6},
            {20, 21, 22, 23, 24, 7},
            {19, 32, 33, 34, 25, 8},
            {18, 31, 36, 35, 26, 9},
            {17, 30, 29, 28, 27, 10},
            {16, 15, 14, 13, 12, 11}
        };
        printSpiralMatrix(arr);
    }
}
