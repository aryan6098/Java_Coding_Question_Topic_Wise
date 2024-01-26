/*
 * Q4. Longest Palindromic Substring
Problem Description
Given a string A of size N, find and return the longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

Incase of conflict, return the substring which occurs first ( with the least starting index).


Problem Constraints
1 <= N <= 6000


Input Format
First and only argument is a string A.


Output Format
Return a string denoting the longest palindromic substring of string A.


Example Input
Input 1:
A = "aaaabaaa"
Input 2:
A = "abba

Example Output
Output 1:
"aaabaaa"
Output 2:
"abba"

Example Explanation
Explanation 1:
We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
Explanation 2:
We can see that longest palindromic substring is of length 4 and the string is "abba".

 */

import java.util.ArrayList;

public class Q4_LongestPalindromicSubstring {

    public static String expand(String str, int p1, int p2) {
        while (p1 >= 0 && p2 < str.length() && (str.charAt(p1)==str.charAt(p2))) {
            p1 = p1-1;
            p2 = p2 + 1;
        }
       
    return str.substring(p1 + 1, p2); 
    }
    public static String longestPalindrome(String A) {
        int ans = 0;
        String longestPalindrome = "";

        for(int i = 0; i < A.length(); i++) {
            int  p1 = i;
            int p2 = i;
            String currentPalindrome = expand(A, p1, p2);
            if (currentPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = currentPalindrome;
            }
        }
        for(int i = 0; i < A.length()-1; i++) {
            int  p1 = i;
            int p2 = i + 1;
            String currentPalindrome = expand(A, p1, p2);
            if (currentPalindrome.length() > longestPalindrome.length()) {
                longestPalindrome = currentPalindrome;
            }
        }
        return longestPalindrome;
    }
    public static void main(String[] args) {
        String str = "abcdckkcd";
        System.out.println(longestPalindrome(str));
    }
}
