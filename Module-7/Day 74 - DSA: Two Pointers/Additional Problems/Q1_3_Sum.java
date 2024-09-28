/*
 * Q1. 3 Sum

 */

import java.util.Arrays;

public class Q1_3_Sum {

    public static int threeSumClosest(int[] A, int B) {
        Arrays.sort(A);
        long current = (long) A[0] + A[1] + A[2];
        for (int i = 0; i < A.length - 2; i++) {
            int a = i;
            int b = i + 1;
            int c = A.length - 1;
            while (b < c) {
                long sum = (long) A[a] + A[b] + A[c];
                if (Math.abs(sum - B) < Math.abs(current - B)) {
                    current = sum;
                }
                if (sum > B) {
                    c--;
                }
                if (sum < B) {
                    b++;
                }
                if (sum == B) {
                    return B;
                }
            }
            
        }
        return (int)current;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 3};
       System.out.println(threeSumClosest(A, 6));
    }
}
