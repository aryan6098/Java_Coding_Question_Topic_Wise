/*
 * 
 */
public class Q5_MatrixSearch {

    public static int searchMatrix(int[][] A, int B) {
        if (A == null || A.length == 0 || A[0].length == 0)
        return 0;
        int row = A.length;
        int col = A[0].length;
        int l = 0;
        int r = (row * col) - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int i = mid / col;
            int j = mid % col;
            if (A[i][j] == B) {
                return 1;
            }
            if (A[i][j] < B) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        int[][] A = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
        };
        
        System.out.println(searchMatrix(A, 33));
    }
}
