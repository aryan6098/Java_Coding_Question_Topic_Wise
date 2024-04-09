public class BinarySearch {
    public static int binarySearch(int[] A, int k) {
        int l = 0;
        int r = A.length - 1;
        while(l <= r) {
            int mid =( l + ((r - l)/2));
            if(A[mid] == k) {
                return mid;
            }
            else if(A[mid] < k) {
                l = mid + 1;
            }
            else if(A[mid] > k) {
                r = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[]A = {3, 6, 9, 12, 14, 19, 20, 23, 25, 27};
        System.out.println(binarySearch(A, 12));
    }
}
