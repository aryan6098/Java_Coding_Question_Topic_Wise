/*
 * Q1. Allocate Books

 */
public class Q1_AllocateBooks {

    public static boolean check(int[] A, int mid, int B) {

        int sum = 0;
        int req = 1;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            if(sum > mid) {
                req++;
                sum = A[i];
            }
        }
        if(req <= B) {
            return false;
        }
        return true;
    }
    
    public static int books(int[] A, int B) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            sum += A[i];
        }

        int l = max;
        int r = sum;
        if(A.length - 1 == B)
        {
            return max;
        }
        if(B >  A.length) {
            return -1;
        }
        while (l <= r) {
            int mid = l + (r - l)/2;
            if(check(A, mid, B)) {
                l = mid + 1;
            }else {
                
                r = mid - 1;
            }
        }
        return l;

    }
    public static void main(String[] args) {
        int[] A = {12, 34, 67, 90};
        int B = 2;
        System.out.println(books(A, B));
    }
}
