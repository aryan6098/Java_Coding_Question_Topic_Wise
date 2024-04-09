/*
 * Q1. Another Count Rectangles

 */
public class Q1_AnotherCountRectangles {

    public static int solve(int[] A, int B) {
        int l = 0;
        int r = A.length - 1;
        int count = 0;
        while(l < A.length  && r >= 0) {
            long area = A[l] * A[r];
            if(area < B) {
                count = count + r;
                l++;
            }else {
                r--;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] A = {1, 2};
        System.out.println(solve(A, 5));
    }
}
