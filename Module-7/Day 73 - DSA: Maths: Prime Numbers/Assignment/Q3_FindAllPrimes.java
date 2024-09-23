/*
 * Q3. Find All Primes

 */

import java.util.ArrayList;

public class Q3_FindAllPrimes {

    public static int countFactor(int n) {
        int count = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    count += 1;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    public static ArrayList<Integer> solve(int A) {
        ArrayList<Boolean> isPrime = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            isPrime.add(true);
        }
        isPrime.set(0, false);
        isPrime.set(1, false);
        for (int i = 2; i * i <= A; i++) {
            if (isPrime.get(i) == true) {
                for (int j = i * i; j <= A; j = j + i) {
                    isPrime.set(j, false);
                }
            }
        }
        for (int i = 2; i < isPrime.size(); i++) {
            if (isPrime.get(i) == true) {
                result.add(i);
            }
        }
        return result;
    }

    public static void primeNumbers(int n) {

        boolean[] isPrimeNumbers = new boolean[n + 1];
        isPrimeNumbers[0] = false;
        isPrimeNumbers[1] = false;
        for (int i = 2; i <= n; i++) {
            isPrimeNumbers[i] = true;
        }

        for (int i = 2; i <= n; i++) {
            if (isPrimeNumbers[i] == true) {
                int j = 2 * i;
                while (j <= n) {
                    isPrimeNumbers[j] = false;
                    j = j + i;
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            if (isPrimeNumbers[i] == true) {
                System.out.println(i + " ");
            }
        }
        // for (int i = 2; i <= n; i++) {
        // if (countFactor(i) == 2) {
        // System.out.print(i + " ");
        // }
        // }

    }

    public static void main(String[] args) {
       System.out.println(solve(7));
        // System.out.println(countFactor(16));
    }

}
