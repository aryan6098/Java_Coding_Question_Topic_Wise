/*
 * Q2. Single Number II

 */

import java.util.Arrays;

public class Q2_SingleNumber_II {

    // T.C ->  O(nlogn)  S.C ->  O(1)
    public static int singleNumber(final int[] A) {
        Arrays.sort(A);
        for(int i = 0; i < A.length - 1; i += 3) {
            if(A[i] != A[i + 1]) {
                return A[i];
            }
        }
        return A[A.length - 1];
    }

    public static int singleNumberMethod2(final int[] A) {
        int ans = 0;
        for(int  i = 0; i < A.length ; i++) {
            int count = 0;
            int ele = A[i];
            for(int j =0; j < A.length; j++ ){
                if(A[j] == ele) {
                    count++;
                }
            }
            if(count == 1) {
                ans = A[i];
            }
        }
        return ans;
    }
    
    public static int singleNumberMethod3(final int[] A) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int count = 0;
            for(int j = 0; j < A.length; j++) {
                if((A[j] & (1 << i)) != 0) {
                    count++;
                }
            }
            if(count % 3 > 0) {
                ans = ans | (1 << i);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 3, 2, 2, 3, 1, 1};
        System.out.println(singleNumber(arr));
        System.out.println(singleNumberMethod2(arr));
        System.out.println(singleNumberMethod3(arr));
        
    }
}
