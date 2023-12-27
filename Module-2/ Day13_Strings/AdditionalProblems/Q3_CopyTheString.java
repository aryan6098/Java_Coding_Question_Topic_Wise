/*
 * Q3. Copy The String

Problem Description

You will be given a constant string (A).

You have to return another copy of that input string after removing last character from it.

Problem Constraints

1 <= A.size() <= 1000

Input Format

First argument containing a lowercase constant string A.

Output Format

You have to return a string as per the question.

Example Input

Input 1:

scaler
Input 2:

interviewbit

Example Output

Output 1:

scale
Output 2:

interviewbi

Example Explanation

Explanation 1:

Clearly, after removing last char(r) from scaler we will have, scale.
Explanation 2:

Clearly, after removing last char(t) from interviewbit we will have, interviewbi.
 */

public class Q3_CopyTheString {

    public static String solve(final String A) {
        String str = "";
        for(int i=0;i<A.length()-1;i++){
            str = str+A.charAt(i);
        }
        return str;
    }
    public static void main(String[] args) {
        System.out.println(solve("interviewbit"));      // interviewbi
    }
}
