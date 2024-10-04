/*
 * Q1. Permutations
Problem Description

Given an integer array A of size N denoting collection of numbers , return all possible permutations.

NOTE:

No two entries in the permutation sequence should be the same.
For the purpose of this problem, assume that all the numbers in the collection are unique.
Return the answer in any order
WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. 
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints

1 <= N <= 9


Input Format

Only argument is an integer array A of size N.


Output Format

Return a 2-D array denoting all possible permutation of the array.


Example Input

A = [1, 2, 3]


Example Output

[ [1, 2, 3]
  [1, 3, 2]
  [2, 1, 3] 
  [2, 3, 1] 
  [3, 1, 2] 
  [3, 2, 1] ]


Example Explanation

All the possible permutation of array [1, 2, 3].
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q1_Permutations {

    // For String

    // public static void generatePermutation(String ques, String ans) {
    // if(ques.length() == 0) {
    // // System.out.println(ans);
    // return;
    // }
    // for(int i = 0; i < ques.length(); i++) {
    // generatePermutation(ques.substring(0, i) + ques.substring(i + 1,
    // ques.length()), ans + ques.charAt(i));
    // }
    // }
    // public static String permutes(String ques) {
    // String ans = "";
    // generatePermutation(ques, ans);
    // return ans;
    // }

    // for Array

    public static void swap(ArrayList<Integer> A, int i, int j) {
        int temp = A.get(i);
        A.set(i, A.get(j));
        A.set(j, temp);
    }

    public static void generatePermutation( ArrayList<ArrayList<Integer>> result, ArrayList<Integer> A, int index) {
        if(index == A.size()) {
            result.add(new ArrayList<>(A)); 
            return;
        }

        for(int i = index; i < A.size() ; i++) {
            swap(A, i, index);
            generatePermutation(result, A, index + 1);
            swap(A, i, index);
        }
    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        generatePermutation(result, A, 0);
        return result;
    }        

    public static void main(String[] args) {
        String ques = "abc";
        // System.out.println(ques.substring(1, ques.length()));
        // permutes("abc");
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2,3));
       System.out.println( permute(arrayList));
    }
}
