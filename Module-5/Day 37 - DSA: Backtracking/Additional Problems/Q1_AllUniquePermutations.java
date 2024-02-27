/*
 * Q1. All Unique Permutations
Problem Description
Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.

NOTE: No 2 entries in the permutation sequence should be the same.

WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS. 
Example : next_permutations in C++ / itertools.permutations in python.
If you do, we will disqualify your submission retroactively and give you penalty points.


Problem Constraints
1 <= |A| <= 9

0 <= A[i] <= 10


Input Format
Only argument is an integer array A of size N.


Output Format
Return a 2-D array denoting all possible unique permutation of the array.

Example Input
Input 1:

A = [1, 1, 2]
Input 2:

A = [1, 2]

Example Output
Output 1:

[ [1,1,2]
  [1,2,1]
  [2,1,1] ]
Output 2:

[ [1, 2]
  [2, 1] ]


Example Explanation
Explanation 1:

 All the possible unique permutation of array [1, 1, 2].
Explanation 2:

 All the possible unique permutation of array [1, 2].
 */

import java.util.ArrayList;
import java.util.Collections;

public class Q1_AllUniquePermutations {

    public static void generatePermutation(ArrayList<Integer> arrayList, ArrayList<Integer> A, int idx , ArrayList<Boolean> visited, ArrayList<ArrayList<Integer>> result) {

        if(idx == arrayList.size()) {
            ArrayList<Integer> permutation = new ArrayList<>(A);
            result.add(permutation);
            return result;
        }
        for(int i = 0 ; i < A.size(); i++) {
            if(visited.get(i) == false) {
                
                visited.set(i, true);
                arr.set(i, A.get(i));
                generatePermutation(arrayList, A, idx + 1, visited, result);
                visited.set(i, false);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        ArrayList<Integer> arr  = new ArrayList<>(A);
        ArrayList<Boolean> visited = new ArrayList<>();
        for(int i = 0; i  <A.size(); i++) {
            visited.add(false);
        }
        Collections.sort(A);
    }

    public static void main(String[] args) {
        
    }
}


