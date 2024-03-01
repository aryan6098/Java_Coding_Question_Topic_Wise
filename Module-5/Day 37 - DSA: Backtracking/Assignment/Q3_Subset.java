/*
 * Q3. Subset
Problem Description
Given a set of distinct integers A, return all possible subsets.

NOTE:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
Also, the subsets should be sorted in ascending ( lexicographic ) order.
The initial list is not necessarily sorted.


Problem Constraints
1 <= |A| <= 16
INTMIN <= A[i] <= INTMAX


Input Format
First and only argument of input contains a single integer array A.



Output Format
Return a vector of vectors denoting the answer.


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


Example Explanation
Explanation 1:

 You can see that these are all possible subsets.
Explanation 2:

You can see that these are all possible subsets.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q3_Subset {

    public static void generateSubsets(ArrayList<Integer> A, int index, ArrayList<Integer> current,
        ArrayList<ArrayList<Integer>> result) {
        result.add(new ArrayList<>(current)); // Add the current subset to the result
        for (int i = index; i < A.size(); i++) {
            if (i > index && A.get(i).equals(A.get(i - 1))) // Skip duplicates
                continue;
            current.add(A.get(i));
            generateSubsets(A, i + 1, current, result); // Generate subsets starting from the next index
            current.remove(current.size() - 1);
        }
    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A); // Sort the input list
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        generateSubsets(A, 0, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,2 3));
        subsets(arr);
    }
}
