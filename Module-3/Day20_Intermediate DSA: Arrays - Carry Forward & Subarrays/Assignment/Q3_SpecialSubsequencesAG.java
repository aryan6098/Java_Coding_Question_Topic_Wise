/*
 * Q3. Special Subsequences "AG"
Problem Description
You have given a string A having Uppercase English letters.

You have to find how many times subsequence "AG" is there in the given string.

NOTE: Return the answer modulo 109 + 7 as the answer can be very large.



Problem Constraints
1 <= length(A) <= 105

Input Format
First and only argument is a string A.


Output Format
Return an integer denoting the answer.


Example Input
Input 1:

 A = "ABCGAG"
Input 2:

 A = "GAB"


Example Output
Output 1:
 3

Output 2:
 0

Example Explanation
Explanation 1:
 Subsequence "AG" is 3 times in given string 

Explanation 2:
 There is no subsequence "AG" in the given string.
 */

import java.util.*;
public class Q3_SpecialSubsequencesAG {

    // 1st Approach 
    // T. C -> O(N^2) 
    // S.C -> O(1)
    // TLE -> time Limit Exceed
    public static int solve(String A) {
        int count = 0 ;
            int mod =((int) Math.pow(10, 9)  + 7);
            for(int  i = 0; i < A.length();i++){
                 if (A.charAt(i) == 'A') {
                    for (int j = i + 1; j < A.length(); j++) {
                        if (A.charAt(j) == 'G') {
                            count++;
                            count %= mod;  
                        }
                    }
                }
                
            }
            return count;    
    }
         //2nd App<roach
    // T. C -> O(N) 
    // S.C -> O(1)
    public static int specialSubsequences(String A){
    int count = 0;
    int ans = 0;
    int mod =((int) Math.pow(10, 9)  + 7);

    for(int i = A.length() - 1; i >=0;i--) {
        if (A.charAt(i) == 'G') {
            count++;
        }
        if(A.charAt(i) == 'A') {
            ans = ans + count;
            ans = ans % mod;
        }
    }
    return ans;
}
   

    public static void main(String[] args) {
        String str = "ABCGAG";
        System.out.println(solve(str));
        System.out.println(specialSubsequences(str));
    }
    
}
