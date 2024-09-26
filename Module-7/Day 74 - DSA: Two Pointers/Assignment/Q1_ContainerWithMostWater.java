/*
 * Q1. Container With Most Water

 */
public class Q1_ContainerWithMostWater {
    public static int maxArea(int[] A) {

        long max = 0;
        int i = 0; 
        int j = A.length - 1;
        while(i < j) {
            long area = (j - i) * Math.min(A[i], A[j]);
            max = Math.max(max, area);
            if(A[i] > A[j]) {
                j--;
            }else if(A[j] > A[i]) {
                i++;
            }else {
                i++;
                j--;
            }
        }
        return max;

    }
    public static void main(String[] args) {
        int[] A = {1};
        System.out.println(maxArea(A));
    }
}
