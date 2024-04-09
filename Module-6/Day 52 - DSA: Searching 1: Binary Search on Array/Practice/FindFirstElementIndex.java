/*
 * Given a sorted array .find first index of given element K
 */
public class FindFirstElementIndex {

    public static int findFirstElementIndex(int[] A, int k) {
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int mid = (l + ((r - l) / 2));
            if (A[mid] == k && (mid == 0 || A[mid - 1] != k)) {
                return mid;
            }

            if (k <= A[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int A[] = {-5, -5, -3, 0, 0, 0, 2, 5, 7, 7};
        System.out.println(findFirstElementIndex(A, 0));
    }
}
