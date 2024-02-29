import java.util.ArrayList;
import java.util.Arrays;

public class Q2_CountOfDivisors {

    public static int countFactor(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            int val = countFactor(A.get(i));
            result.add(val);
        }
        return result;
    }


    // Method 2 - > sieve of eratosthenes
    public static int[] getSmallestPrimeFactor() {
        int[] spfArray = new int[1000001];
        for(int i = 2 ; i < spfArray.length; i++) {
            spfArray[i] = i;
        }
        for(int i = 2; i * i <= spfArray.length; i++) {
            if(spfArray[i] == i) {
                for(int j = i * i; j < spfArray.length; j = j + i) {
                   if(spfArray[j] == j) {
                       spfArray[j] = i;
                   }
                }
            }
        }
        return spfArray;
    }

    public static int countNoOfFactor(int n, int[] smallestPrimeFactorArray) {
        int ans = 1;
        while (n > 1) {
            int count = 0;
            int s = smallestPrimeFactorArray[n];
            while (n % s == 0) {
                n = n / s;
                count++;
            }
            ans = ans * (count + 1);
        }
        return ans;
    }

    public static int[] solveMethod1(int A[]) {
        int result[] = new int[A.length];
        int[] smallestPrimeFactorArray = getSmallestPrimeFactor();
        for (int i = 0; i < A.length; i++) {
            int val = countNoOfFactor(A[i], smallestPrimeFactorArray);
            result[i] = val;
        }
        return result;
    }

    public static void main(String[] args) {

        int[] res = {  8, 9, 10};
        int[] result = solveMethod1(res);
        for (int i = 0; i < res.length; i++) {
            System.out.print(result[i] + " ");
        }

    }
}
