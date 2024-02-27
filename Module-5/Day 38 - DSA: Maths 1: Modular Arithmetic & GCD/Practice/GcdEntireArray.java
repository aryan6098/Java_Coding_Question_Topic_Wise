/*
 * Given an A[], calculate Gcd of Entire Array;
 */
public class GcdEntireArray {

    public static int gcd(int A, int B) {
        if(B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }
    public static int calculateGcd(int[] A) {
        int ans = 0; 
        for(int i = 0; i < A.length; i++) {
            ans = gcd(ans, A[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {6, 12, 15};

        System.out.println(calculateGcd(arr));
    }
}
