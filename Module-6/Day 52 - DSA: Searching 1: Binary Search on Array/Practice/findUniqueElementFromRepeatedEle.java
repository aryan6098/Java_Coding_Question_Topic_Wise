public class findUniqueElementFromRepeatedEle {

    public static int findRepeatedEle(int[] A) {
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int mid = l + ((r - l)/2);
            if((mid == 0 || (A[mid - 1] != A[mid])) && (mid == A.length - 1 || (A[mid + 1] != A[mid]) )) {
                return A[mid];
            }
            if(mid == 0 || A[mid - 1] != A[mid]) {
               if(mid % 2 == 0) {
                l = mid + 1;
               }
               else {
                r = mid - 1;
               }
            }
            else {
                if(mid % 2 == 0) {
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] A = {1, 1, 3, 3,5,6,5};
        System.out.println(findRepeatedEle(A));
    }
}
