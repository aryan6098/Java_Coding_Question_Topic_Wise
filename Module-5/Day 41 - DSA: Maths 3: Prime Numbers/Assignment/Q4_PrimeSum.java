/* 
 * Q4. Prime Sum
Problem Description
Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.

If there is more than one solution possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then 
[a, b] < [c, d], If a < c OR a==c AND b < d. 
NOTE: A solution will always exist. Read Goldbach's conjecture.


Problem Constraints
4 <= A <= 2*107


Input Format
First and only argument of input is an even number A.


Output Format
Return a integer array of size 2 containing primes whose sum will be equal to given number.


Example Input
 4

Example Output
 [2, 2]

Example Explanation
 There is only 1 solution for A = 4.
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Q4_PrimeSum {

    public static ArrayList<Integer> primeNums(int n) {
        Boolean[] arr  = new Boolean[n + 1];
        Arrays.fill(arr, true);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arr[0] = false;
        arr[1] = false;
        for(int i  = 2; i * i <= n; i++) {
            if(arr[i] == true) {
                for(int j = i * i; j <= n; j = j + i) {
                    arr[j] = false;
                }
            }
        }

        for(int i = 2; i <= n ; i++) {
            if((arr[i] == true) && (arr[n - i] == true)) {
                if(i + (n - i)  == n) {
                    arrayList.add(i);
                    arrayList.add(n - i);
                    break;
                }
                
            }
        }
        return arrayList;
    }
    public static int[] primesum(int A) {
        ArrayList<Integer> result = primeNums(A);
        return result;
    }
    public static void main(String[] args) {
        ArrayList<Integer>  = primesum(12);
        System.out.println(result);
    }
}
