/*
 * Q5. High to Low - II
Problem Description

You are given uppercase string (S) and you have to return a string that is the lower case form of S.

Uppercase strings are those which have all letters in uppercase (Example: MACHINE)

Lowercase strings are those which have all letters in lowercase (Example: machine)

Problem Constraints

1 <= S.size() <= 1000
Input Format

First and only argument containing a uppercase string **S**.
Output Format

You have to return lowercase form of input string.
Example Input

Input 1:
INTERVIEWBIT
Input 2:
SCALER
Example Output

Output 1:
interviewbit
Output 2:
scaler
Example Explanation

Explanation 1:
Clearly, lowercase of INTERVIEWBIT is interviewbit.
Explanation 2:
Clearly, lowercase of SCALER is scaler.
 */



public class Q5_HighToLow_II {
    public static String solve(String A) {
        char[] str = A.toCharArray();
        for(int i=0;i<str.length;i++)
        {
            if(str[i]>=65 && str[i]<=90){
                str[i] = (char)(str[i] + 32);
            }
        }
       return String.valueOf(str);
    }
    public static void main(String[] args) {
        System.out.println(solve("INTERVIEWBIT"));

   }
}
    
