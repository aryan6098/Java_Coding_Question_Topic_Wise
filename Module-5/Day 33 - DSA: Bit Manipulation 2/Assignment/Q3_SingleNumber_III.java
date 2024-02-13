/*
 * Q3. Single Number III
Problem Description
Given an array of positive integers A, two integers appear only once, and all the other integers appear twice.
Find the two integers that appear only once.

Note: Return the two numbers in ascending order.


Problem Constraints
2 <= |A| <= 100000
1 <= A[i] <= 109



Input Format
The first argument is an array of integers of size N.



Output Format
Return an array of two integers that appear only once.


Example Input
Input 1:
A = [1, 2, 3, 1, 2, 4]
Input 2:

A = [1, 2]


Example Output
Output 1:
[3, 4]
Output 2:

[1, 2]


Example Explanation
Explanation 1:
3 and 4 appear only once.
Explanation 2:

1 and 2 appear only once.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q3_SingleNumber_III {

    // T.C -> O(n2) S.C -> O(n2)
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            int count = 0;
            for (int j = 0; j < A.size(); j++) {
                if (A.get(i) == A.get(j)) {
                    count++;
                }
            }
            if (count == 1) {
                result.add(A.get(i));
            }
        }
        return result;
    }

    public static void solveMethod2(ArrayList<Integer> A) {
        
        int val = 0;

        for (int i = 0; i < A.size(); i++) {
            val = val^A.get(i);
        }
        System.out.println(val);
    }

    public static ArrayList<Integer> solveMethod1(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int val = 0;
        int idx = -1;
        int set = 0;
        int unset = 0;
        for (int i = 0; i < A.size(); i++) {
            val = val ^ A.get(i);
        }

        for (int i = 0; i < 32; i++) {
            if ((val & (1 << i)) > 0) {
                idx = i;
                break;
            }
        }
        for (int i = 0; i < A.size(); i++) {
            if ((A.get(i) & (1 << idx)) > 0) {
                set = set ^ A.get(i);
            } else {
                unset = unset ^ A.get(i);
            }
        }
        result.add(Math.min(set, unset));
        result.add(Math.max(set, unset));
        return result;
    }

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(2308, 1447, 1918, 1391, 2308, 216, 1391, 410, 1021,
                537, 1825, 1021, 1729, 669, 216, 1825, 537, 1995, 805, 410, 805, 602, 1918, 1447, 90, 1995, 90, 1540,
                1161, 1540, 2160, 1235, 1161, 602, 880, 2160, 1235, 669));
        ArrayList<Integer> arrayList1 = new ArrayList<>(Arrays.asList(186, 256, 102,102 ,377, 186, 377));
        // ArrayList<Integer> result = solve(arrayList);
        // System.out.println(result);
        // ArrayList<Integer> result1 = solveMethod1(arrayList1);
        // System.out.println(result1);
        solveMethod2(arrayList1);
    }
}
