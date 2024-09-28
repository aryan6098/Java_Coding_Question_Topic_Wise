/*
 * Q2. Generate all Parentheses II
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

public class Q2_GenerateAll_ParenthesesII {
    public static void printParenthesis(ArrayList<String> result, String ans, int openingBracesCount, int closingBracesCount, int A) {
        if(ans.length() == 2 * A) {
            result.add(ans);
            return;
        }

        if(openingBracesCount < A) {
            printParenthesis(result, ans + "(" , openingBracesCount + 1,  closingBracesCount, A);
        }
        if(closingBracesCount < openingBracesCount) {
            printParenthesis(result, ans + ")", openingBracesCount , closingBracesCount + 1 , A);
        }
        return;
    }

    public static ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> result = new ArrayList<>();
        printParenthesis(result, "", 0, 0, A);
        return result;
    }


    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
