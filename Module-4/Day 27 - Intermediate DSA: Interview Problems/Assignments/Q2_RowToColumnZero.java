/*
 * Q2. Row to Column Zero

 */
public class Q2_RowToColumnZero {
    public static void solve(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] arr = new int[row][col];
        
        int rowIndex = -1;
        int colIndex = -1;
        for(int  i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(A[i][j] == 0) {
                    rowIndex = i;
                    colIndex = j;
                    for(int k = 0; k < j; k++) {
                        arr[i][k] = 0;
                    }
                    for(int k = 0; k < i; k++) {
                        arr[k][j] = 0;
                    }
                }

                else if(rowIndex!=i && colIndex!=j){

                    arr[i][j] = A[i][j];
                }
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

      
    public static void main(String[] args) {
       int[][] arr = {{7,8,0,9},{5,6,7,1},{9,2,3,4}};
       solve(arr);
    }
}
