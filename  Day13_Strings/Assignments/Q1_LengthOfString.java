/*
 * Q1. Length of String
Problem Description
Write a program to input an integer T and then each of T lines will have a string (S).

You have to print T lines each containing length of input string.

Problem Constraints
1 <= T <= 100

1 <= S.size() <= 1000

Input Format
First line is T which means number of test cases.

Each next T lines contain a string S.

Output Format
T lines each containing an integer representing length of the input string.


Example Input
Input 1:

2
scaler
interviewbit


Example Output
Output 1:

6
12

 */

import java.util.Scanner;

public class Q1_LengthOfString {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        int test = sc.nextInt();
        sc.nextLine();
        while(test>0){
            String str = sc.nextLine();
            System.out.println(str.length());
            test--;
        }
    }
}
