/*
 * Q4. Evaluate Expression
Problem Description
An arithmetic expression is given by a string array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each string may be an integer or an operator.

Note: Reverse Polish Notation is equivalent to Postfix Expression, where operators are written after their operands.


Problem Constraints
1 <= N <= 105


Input Format
The only argument given is string array A.



Output Format
Return the value of arithmetic expression formed using reverse Polish Notation.


Example Input
Input 1:
A =   ["2", "1", "+", "3", "*"]
Input 2:
A = ["4", "13", "5", "/", "+"]


Example Output
Output 1:
9
Output 2:
6


Example Explanation
Explaination 1:
starting from backside:
    * : () * ()
    3 : () * (3)
    + : (() + ()) * (3)
    1 : (() + (1)) * (3)
    2 : ((2) + (1)) * (3)
    ((2) + (1)) * (3) = 9
Explaination 2:
starting from backside:
    + : () + ()
    / : () + (() / ())
    5 : () + (() / (5))
    13 : () + ((13) / (5))
    4 : (4) + ((13) / (5))
    (4) + ((13) / (5)) = 6
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q4_EvaluateExpression {
    public static int evalRPN(ArrayList<String> A) {
    ArrayList<Integer> stack = new ArrayList<>();
    for(int i = 0 ; i  < A.size(); i++) {
        String token = A.get(i);
        if (token.equals("+") || token.equals("*") || token.equals("-") || token.equals("/")) {
            int val1 = stack.remove(stack.size() - 1);
            int val2 = stack.remove(stack.size() - 1);
            int res = 0;
            switch (token) {
                case "+":
                    res = val1 + val2;
                    break;
                case "-":
                    res = val2 - val1;
                    break;
                case "*":
                    res = val2 * val1;
                    break;
                case "/":
                    if(val1 != 0) {
                        res = val2 / val1;
                    }
                    break;
                default:
                    break;
            }
            stack.add(res);

        }
        else {
            stack.add(Integer.parseInt(token));
        }
    }
    return stack.get(0);
    }
        
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("2", "1", "+", "3", "/"));
        System.out.println(evalRPN(arrayList));
    }
}
