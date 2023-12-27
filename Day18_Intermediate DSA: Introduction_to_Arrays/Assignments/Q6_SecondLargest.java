/*
 * Q6. Second Largest
Problem Description
You are given an integer array A. You have to find the second largest element/value in the array or report that no such element exists.

Problem Constraints
1 <= |A| <= 105

0 <= A[i] <= 109


Input Format
The first argument is an integer array A.


Output Format
Return the second largest element. If no such element exist then return -1.


Example Input
Input 1:

 A = [2, 1, 2] 
Input 2:

 A = [2]


Example Output
Output 1:

 1 
Output 2:

 -1 

Example Explanation
Explanation 1:

 First largest element = 2
 Second largest element = 1
Explanation 2:

 There is no second largest element in the array.
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q6_SecondLargest {
    public static int solve(ArrayList<Integer> A) {
        int index = 0;
        for(int i=0;i<A.size();i++){
            if(A.get(index) < A.get(i)){
                index = i;
            }
        }
        int secondLargest = -1;
        for(int i=0;i<A.size();i++){
            if(A.get(index)!=A.get(i)){
                secondLargest = Math.max(secondLargest, A.get(i));
            }
        }

        return secondLargest;

    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(13,7,16,18,14,17,18,8,10));
        System.out.println(solve(arrayList));
    }
}

