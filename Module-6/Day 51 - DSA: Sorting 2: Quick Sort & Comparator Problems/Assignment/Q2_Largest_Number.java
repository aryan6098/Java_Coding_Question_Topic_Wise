/*
 * Q2. Largest Number
Problem Description
Given an array A of non-negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109



Input Format
The first argument is an array of integers.


Output Format
Return a string representing the largest number.



Example Input
Input 1:

 A = [3, 30, 34, 5, 9]
Input 2:

 A = [2, 3, 9, 0]


Example Output
Output 1:

 "9534330"
Output 2:

 "9320"


Example Explanation
Explanation 1:

Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
Explanation 2:

Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q2_Largest_Number {
    public static String largestNumber(ArrayList<Integer> A) {

        String[] str = new String[A.size()];

        for(int i = 0; i < A.size(); i++) {
            str[i] = String.valueOf(A.get(i));
        }

        Comparator<String> comp = new Comparator<String>() {
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;

                return order2.compareTo(order1);
            }
        };

        // ArrayList<String> strList = Arrays.asList(str);
         Arrays.sort(str, comp);
         if (str[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String num : str) {
            result.append(num);
        }

        return result.toString();



    }

    public static void main(String[] args) {

        ArrayList<Integer> aa = new ArrayList<>(Arrays.asList(3, 30,  34, 5, 9));
        System.out.println(largestNumber(aa));
    }
    
}
