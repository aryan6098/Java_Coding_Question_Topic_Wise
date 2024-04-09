/*
 * 
 */
public class findUniqueElement {

    public static int findLeftIndex (int A[], int B) {
        int l = 0;
        int r = A.length - 1;
        while(l <= r) {
            int mid = l + ((r- l)/2);
            if((mid == 0 || (A[mid - 1] < B)) && A[mid] == B) {
                return mid;
            }
            if(A[mid] < B) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return -1;
    } 
    public static int findRightIndex(int[] A, int B) {
        int l = 0;
        int r = A.length - 1;
        while(l <= r) {
            int mid = l + ((r- l)/2);
            if((mid == A.length - 1 || A[mid + 1] > B) && A[mid] == B) {
                return mid;
            }
            if(A[mid] > B) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return -1;
    }
    public static int[] searchRange(final int[] A, int B) {

        int[] res = new int[2];
        int l = 0;
        int r = A.length - 1;
        int mid = l + ((r- l)/2);
        res[0] = findLeftIndex(A, B);
        res[1] = findRightIndex(A, B);
        // System.out.println(findLeftIndex(A, B));
        // System.out.println(findRightIndex(A, B));
        return res;
    }
    public static void main(String[] args) {
        int[] A = {5, 7, 7, 8, 8, 10};
        searchRange(A, 8);
    }
}
