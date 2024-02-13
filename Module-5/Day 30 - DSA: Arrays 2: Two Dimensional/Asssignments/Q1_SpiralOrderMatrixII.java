/*
 * Q1. Spiral Order Matrix II

 */
public class Q1_SpiralOrderMatrixII {
    public static int[][] generateMatrix(int A) {
        int[][] result = new int[A][A];
        int count = 1;
        int n = A;
        int i = 0;
        int j = 0;
        while (n > 0) {
            // Print top row from left to right
            for (int k = 0; k < n; k++) {
                result[i][j++] = count;
                count++;
            }
            i++; // Move to the next row
            j--; // Adjust j back to the last valid position

            // Print right column from top to bottom
            for (int k = 0; k < n - 1; k++) {
                result[i++][j] = count;
                count++;
            }
            i--; // Adjust i back to the last valid position
            j--; // Move to the previous column

            // Print bottom row from right to left
            for (int k = 0; k < n - 1; k++) {
                result[i][j--] = count;
                count++;
            }
            i--; // Move to the previous row
            j++; // Adjust j back to the last valid position

            // Print left column from bottom to top
            for (int k = 0; k < n - 2; k++) {
                result[i--][j] = count;
                count++;
            }
            i++; // Adjust i back to the last valid position
            j++; // Move to the next column

            n -= 2; // Reduce the size for the next iteration
        }

        // Print the center element if any
        if (n == 1) {
            result[i][j] = count;
                count++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] result = generateMatrix(1);
        for(int k = 0 ; k < result.length; k++) {
            for(int m = 0; m < result[0].length; m++) {
                System.out.print(result[k][m] +" ");
            }
            System.out.println();
        }
    }
}
