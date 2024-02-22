/*
 * Q1. Generate all Parentheses II
Problem Description
Given an integer A pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*A.


Problem Constraints
1 <= A <= 10


Input Format
First and only argument is integer A.


Output Format
Return a sorted list of all possible parenthesis.


Example Input
Input 1:
A = 3

Input 2:
A = 1

Example Output
Output 1:
[ "((()))", "(()())", "(())()", "()(())", "()()()" ]

Output 2:
[ "()" ]

Example Explanation
Explanation 1:

 All paranthesis are given in the output list.
Explanation 2:

 All paranthesis are given in the output list.

 */

import java.util.ArrayList;

public class Q1_GenerateAllParentheses {

    public static void addParenthesis(ArrayList<String> arrayList, String ans , int open, int close, int A) {

        if(2 * A == ans.length()) {
            arrayList.add(ans);
            return;
        }
        if(open < A) {
           addParenthesis(arrayList, ans + "(", open + 1, close, A);
        }
        if(close < open) {
          addParenthesis(arrayList, ans + ")", open, close + 1, A);
        }
    }

    public static ArrayList<String> generateParenthesis(int A) {

        ArrayList<String> result = new ArrayList<>();
        addParenthesis(result, "", 0, 0, A);
        return result;
    }


    
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
