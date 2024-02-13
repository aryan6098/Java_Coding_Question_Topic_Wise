/*
 * Given a row wise and column wise sorted matrix Search for an element k
 * 
 */
public class SearchKSortedMatrix {

    public static boolean searchKSortedMatrix(int[][] arr, int k) {
        int i = 0;
        int j = arr[0].length - 1 ;
        System.out.println(j);
        while(i < arr.length && j >= 0) {
            if(arr[i][j] == k) {
                return true;
            }
            else if(arr[i][j] > k) {
                j--;
            }
            else if(arr[i][j] < k) {
                i++;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        int[][] arr = {
            // {-5, -2, 1 ,13}, {-4, 0, 3, 14}, {-3, 2, 6, 18}
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        };

       System.out.println( searchKSortedMatrix(arr, 2));
    }
}
