public class LocalMinima {

    public static int findLocalMinima(int[] A) {
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int mid = l + ((r - l)/2);
            if((mid==0 || (A[mid -1] > A[mid])) && (mid == A.length - 1 ||( A[mid + 1] > A[mid]))) {
                return A[mid];
            }
            if(mid == 0 || A[mid - 1] > A[mid]) {
                l = mid + 1;
            }else {
                r= mid - 1;
            }
        }
        return -1;
    }

     public static void main(String[] args) {
        int[] A = {3, 6, 1, 0, 9, 15, 8};
        System.out.println(findLocalMinima(A));
     }
}