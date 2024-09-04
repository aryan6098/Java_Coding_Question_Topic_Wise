/*
 * Q2. Search for a Range

 */
public class Q2_Search_for_a_Range {

    public static int rightMost(int[] A, int B) {
        int l = 0;
        int r = A.length - 1;
        int rightAns = -1;

        while(l <= r) {
            int mid = l + (r - l)/2;
            if(A[mid] == B) {
                rightAns = mid;
                l = mid + 1;
            }
            else if(A[mid] < B) {
                l = mid + 1;
            }else {
                r = mid -1;
            }
        }
        return rightAns;
    }
    public static int leftMost(int[] A, int B) {
        int l = 0;
        int r = A.length - 1;
        int leftAns = -1;

        while (l <= r) {
            int mid = l + (r - l)/2;
            if(A[mid] == B) {
                leftAns = mid;
                r = mid - 1;
            }
            else if(A[mid] < B) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return leftAns;
    }

    public static int[] searchRange(final int[] A, int B) {

        int[] result = new int[2];
        
        result[0] = leftMost(A, B);
        result[1] = rightMost(A, B);
        return result;

    }
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int[] result = searchRange(arr, 8);
        for(int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
