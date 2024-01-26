/*
 * Q2. Simple Reverse
Problem Description
Given a string A, you are asked to reverse the string and return the reversed string.



Problem Constraints
1 <= |A| <= 105

String A consist only of lowercase characters.



Input Format
First and only argument is a string A.



Output Format
Return a string denoting the reversed string.

Example Input
Input 1:

 A = "scaler"
Input 2:

 A = "academy"

Example Output
Output 1:
"relacs"

Output 2:
 "ymedaca"


Example Explanation
Explanation 1:

 Reverse the given string.

 */

public class Q2_SimpleReverse {
    public static String solve(String A) {
        char[] str = A.toCharArray();
        int st = 0;
        int end = A.length()-1;
        while(st <= end) {
            char temp = A.charAt(st);
            str[st] = A.charAt(end);
            str[end] = temp;
            st++;
            end--;
        }
        String reverseString = String.valueOf(str);
        return reverseString;
    }
    public static void main(String[] args) {
        String str = "Hello";
        System.out.println(solve(str));
    }
}
