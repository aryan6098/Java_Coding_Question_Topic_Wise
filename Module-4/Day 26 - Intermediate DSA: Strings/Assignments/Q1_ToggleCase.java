/*
 * Q1. Toggle Case
Problem Description
You are given a character string A having length N, consisting of only lowercase and uppercase latin letters.

You have to toggle case of each character of string A. For e.g 'A' is changed to 'a', 'e' is changed to 'E', etc.



Problem Constraints
1 <= N <= 105

A[i] ∈ ['a'-'z', 'A'-'Z']



Input Format
First and only argument is a character string A.



Output Format
Return a character string.



Example Input
Input 1:

 A = "Hello" 
Input 2:

 A = "tHiSiSaStRiNg" 


Example Output
Output 1:

 hELLO 
Output 2:

 ThIsIsAsTrInG 


Example Explanation
Explanation 1:

 'H' changes to 'h'
 'e' changes to 'E'
 'l' changes to 'L'
 'l' changes to 'L'
 'o' changes to 'O'
Explanation 2:

 "tHiSiSaStRiNg" changes to "ThIsIsAsTrInG".
 */
public class Q1_ToggleCase {

    public static String solveMethod1(String A) {

        char[] str = A.toCharArray();
        for(int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if(ch  >= 65 && ch <= 90) {
               str[i] = (char)(ch+ 32);
            }
            else if (ch >= 97 && ch <= 122){
                str[i] = (char)(ch - 32);
            }
        }
        String toggleString = String.valueOf(str);
        return toggleString;
    }
    public static String solveMethod2(String A) {
        char[] str = A.toCharArray();
        for(int i = 0;i < A.length(); i++) {
            char ch = A.charAt(i);
            if(ch >= 'A' && ch <= 'Z') {
                str[i] = (char)(ch - 'A'  + 'a');
            }
            else if(ch >= 'a' && ch <= 'z') {
                str[i] = (char)(ch - 'a' +  'A');
            }
        }
        String toggleString = String.valueOf(str);
        return toggleString;
    }
    public static void main(String[] args) {
        String str = "hELLO";
        System.out.println(solveMethod2(str));
        // System.out.println((char)('a'-32));
    }
}
