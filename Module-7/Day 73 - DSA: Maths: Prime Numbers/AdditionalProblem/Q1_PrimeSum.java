/*
Q1. Prime Sum

 * Problem Description
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
import java.util.HashMap;

public class Q1_PrimeSum {

    public static int[] primesum(int A) {

        int[] isPrime = new int[A + 1];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        isPrime[0] = 0;
        isPrime[1] = 0;

        int[] res = new int[2];
        for(int i = 2; i <= A; i++) {
            isPrime[i] = 1;
        }
        for(int i = 2; i * i <= A; i++) {
            if(isPrime[i] == 1) {
                for(int j = i * i; j <= A; j = j + i) {
                    isPrime[j] = 0;
                }
            }
        }
       
        for(int i = 0; i < isPrime.length; i++) {
            if(isPrime[i] == 1) {
                if (hashMap.get(A - i) != null) { 
                    res[0] = A - i;
                    res[1] = i;
                } else if (i + i == A) {
                    res[0] = i;
                    res[1] = i;
                }else {
                    hashMap.put(i, i); 
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
       int[] res =  primesum(4);
       for(int i = 0; i < res.length; i++) {
        System.out.print(res[i] +" ");
       }
        
    }
}
