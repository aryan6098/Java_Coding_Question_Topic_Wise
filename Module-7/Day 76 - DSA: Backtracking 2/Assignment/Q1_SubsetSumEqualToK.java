/*
 * Q1. Subset Sum equal to K
Problem Description

Given a set of distinct integers A, return all possible subsets that can be formed from the elements of array A.


Problem Constraints

1 ≤ |A| ≤ 16

INT_MIN ≤ A[i] ≤ INT_MAX

Array A is given in increasing order.

All elements of array A are distinct.


Input Format

First and only argument of input contains a single integer array A.


Output Format

Return a vector of vectors denoting the answer in any order.


Example Input

Input 1:

A = [1]
Input 2:

A = [1, 2, 3]

Example Output

Output 1:

[
    []
    [1]
]
Output 2:

[
 []
 [1]
 [1, 2]
 [1, 2, 3]
 [1, 3]
 [2]
 [2, 3]
 [3]
]
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q1_SubsetSumEqualToK {

    public static boolean generateSubset(ArrayList<Integer> A, int index, int sum, int B) {

        if (index == A.size()) {
            return sum == B;
        }
        if (generateSubset(A, index + 1, sum, B)) {
            return true;
        }
        // ans.add(A.get(index));
        if (generateSubset(A, index + 1, sum + A.get(index), B)) {
            return true;
        }
        return false;
    }

    public static int SubsetSum(ArrayList<Integer> A, int B) {
        return generateSubset(A, 0, 0, B) ? 1 : 0;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println(SubsetSum(arrayList, 3));
    }
}
