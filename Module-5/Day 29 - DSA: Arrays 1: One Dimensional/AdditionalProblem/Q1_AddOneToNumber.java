/*
 * Q1. Add One To Number
Solved
feature icon
Get your doubts resolved blazing fast with Chat GPT Help
Check Chat GPT
feature icon
Using hints is now penalty free
Use Hint
Problem Description
Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :

Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
A: For the purpose of this question, YES
Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.


Problem Constraints
1 <= size of the array <= 1000000

Input Format
First argument is an array of digits.


Output Format
Return the array of digits after adding one.


Example Input
Input 1:

[1, 2, 3]

z
Example Output
Output 1:

[1, 2, 4]


Example Explanation
Explanation 1:

Given vector is [1, 2, 3].
The returned vector should be [1, 2, 4] as 123 + 1 = 124.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Q1_AddOneToNumber {

    public static void reverse(ArrayList<Integer> A) {
        int st = 0;
        int end = A.size() - 1;
        while (st < end) {
            int temp = A.get(st);
            A.set(st, A.get(end));
            A.set(end, temp);
            st++;
            end--;
        }
    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int index = 0;

        while (index < A.size() && A.get(index) == 0) {
            A.remove(index);
        }
        reverse(A);
        int carry = 1;
        for (int i = 0; i < A.size(); i++) {
            int sum = A.get(i) + carry;
            A.set(i, sum % 10);
            carry = sum / 10;
        }
        reverse(A);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        if (carry > 0) {
            for (int i = 0; i < A.size(); i++) {
                result.add(A.get(i));
            }
            return result;
        }

        return A;

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(0, 0, 0, 9, 9, 9));
        ArrayList<Integer> result = plusOne(arr);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + "  ");
        }

    }
}
