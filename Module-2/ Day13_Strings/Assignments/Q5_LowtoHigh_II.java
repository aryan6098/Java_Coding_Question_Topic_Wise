/*
 * Q5. Low to High - II

Problem Description
You are given lowercase string (S) and you have to return a string that is the uppercase form of S.

Problem Constraints
1 <= S.size() <= 1000

Input Format
First and only argument containing a lowercase string S.

Output Format
You have to return uppercase form of input string.

Example Input
Input 1:

interviewbit
Input 2:

scaler

Example Output
Output 1:

INTERVIEWBIT
Output 2:

SCALER

Example Explanation
Explanation 1:

Clearly, uppercase of interviewbit is INTERVIEWBIT.
Explanation 2:

Clearly, uppercase of scaler is SCALER.
 */

public class Q5_LowtoHigh_II {

    // public static String solve(String A) {
    //     char[] str = A.toCharArray();
    //     for(int i=0;i<str.length;i++){
    //         if(str[i]>=97 && str[i]<=122){
    //             str[i] = (char) (str[i] - 32);
    //         }
    //     }

    //     String upperCaseString = String.valueOf(str);

    //     return upperCaseString;
    // }

    public static String solve(String A) {
        return A.toUpperCase();
    }
    public static void main(String[] args) {
    System.out.println(solve("interviewbit"));
        
    }
}
