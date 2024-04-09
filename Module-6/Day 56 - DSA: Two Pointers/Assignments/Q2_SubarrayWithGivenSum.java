/*
 * Q2. Subarray with given sum
Problem Description
Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.

If the answer does not exist return an array with a single integer "-1".

First sub-array means the sub-array for which starting index in minimum.


Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
1 <= B <= 109


Input Format
The first argument given is the integer array A.

The second argument given is integer B.


Output Format
Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single integer "-1".


Example Input
Input 1:

 A = [1, 2, 3, 4, 5]
 B = 5
Input 2:

 A = [5, 10, 20, 100, 105]
 B = 110


Example Output
Output 1:

 [2, 3]
Output 2:

 [-1]


Example Explanation
Explanation 1:

 [2, 3] sums up to 5.
Explanation 2:

 No subarray sums up to required number.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q2_SubarrayWithGivenSum {
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int sum = A.get(0);
        int i = 0;
        int j = 0;
        while(j < A.size()) {
            if(sum == B) {
                for(int st = i; st <= j; st++) {
                    arrayList.add(A.get(st));
                }
                return arrayList;
            } 
            if(sum < B) {
                j++;
                if(j ==A.size()) {
                    arrayList.add(-1);
                }
                else {
                    sum = sum + A.get(j);
                }
            }
            else {
                sum -= A.get(i);
                i++;
            }
        }
        return arrayList;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(5, 10, 20, 100, 105));
        System.out.println(solve(arrayList, 110));
    }
}
