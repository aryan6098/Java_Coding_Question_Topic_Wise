public class SortedBinaryMatrix {
    public static int binarySortedMatrix(int[][] arr) {
        int ans = 0;
        int i = 0; 
        int j = arr[0].length - 1;
        while (i < arr.length && j >= 0) {
            while (j >= 0 && arr[i][j] == 1) {
                j--;
                ans = i;
            }
            i++;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr = {
            {0, 0 , 0, 0}, {0 , 0, 0, 1}, {0 , 0, 1, 1}, {0 , 1, 1, 1}
        };
        System.out.println(binarySortedMatrix(arr));
    }
}
