/*
 * Q1. Aggressive cows

 */

import java.util.Arrays;

public class Q1_AggressiveCows {

    public static boolean check(int[] A, int mid, int totalCows) {
        int cowsPlaced = 1;
        int lastPosition = A[0];
        for(int i = 0; i < A.length; i++) {
            if(A[i] - lastPosition >= mid) {
                lastPosition = A[i];
                cowsPlaced++;
            }
        }
    
        if(cowsPlaced < totalCows) {
            return false;
        }
        return true;
        
    }

    public static int solve(int[] A, int B) {

        Arrays.sort(A);
        int l = 1; 
        int r = A[A.length - 1];
        int ans = l;
        while (l <= r) {
            int mid = l + (r- l)/2;
            if(check(A, mid, B)) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;

    }
    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4, 5};
        int B = 2;
        System.out.println(solve(A, B));
        
    }
}
