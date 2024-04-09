/*
 * Q4. Pairs with given sum II

 */

import java.util.Arrays;

public class Q4_PairsWithGivenSumII {

    public static int solve(int[] A, int B) {
        long count = 0;
        int MOD = 1000000007;
        int i = 0;
        Arrays.sort(A);
        int j = A.length - 1;
        // while (i < j) {
        //     if(A[i] + A[j] < B) {
        //         i++;
        //     }
        //     else if(A[i] + A[j] > B) {
        //         j--;
        //     }else {
        //         if(A[i] == A[j]) {
        //             int x = j - i + 1;
        //             count += (x * (x - 1))/2;
        //             count %= MOD;
        //             return (int)count;
        //         }
        //         else {
        //             int c1 = 1;
        //             while(A[i]== A[i + 1]) {
        //                 c1++;
        //                 i++;
        //             }
        //             int c2 = 1;
        //             while(A[j] == A[j - 1]) {
        //                 c2++;
        //                 j--;
        //             }
        //             count += (long) (c1 * c2);
        //             count %= MOD;
        //             i++;
        //             j--;
        //         }
        //     }
        // }
        // return (int)(count % MOD);

        while (i < j) {
            if(A[i] + A[j] < B) {
                i++;
            }
            else if(A[i] + A[j] > B) {
                j--;
            }else {
                if(A[i] == A[j]) {
                long x = j - i + 1;
                    count += ((x * (x - 1))/2)% MOD;
                    count %= MOD;
                    return (int)count;
                }
                else {
                    int c1 = 1;
                    while (A[i] == A[i + 1]) {
                        c1++;
                        i++;
                    }
                    int c2 = 1;
                    while (A[j] == A[j - 1]) {
                        c2++;
                        j--;
                    }
                    count += (c1* c2)%MOD;
                    count %= MOD;
                    i++;
                    j--;
                }
            }
            
        }
        return (int)(count % MOD);
    }
    public static void main(String[] args) {
        int[] A = {1, 5, 7, 10};
        int b = 8;
        System.out.println(solve(A, b));
    }
}
