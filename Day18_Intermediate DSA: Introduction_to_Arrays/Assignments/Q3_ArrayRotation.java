/*
 * Q3. Array Rotation
Problem Description
Given an integer array A of size N and an integer B, you have to return the same array after rotating it B times towards the right.


Problem Constraints
1 <= N <= 105
1 <= A[i] <=109
1 <= B <= 109


Input Format
The first argument given is the integer array A.
The second argument given is the integer B.


Output Format
Return the array A after rotating it B times to the right


Example Input
Input 1:

A = [1, 2, 3, 4]
B = 2
Input 2:

A = [2, 5, 6]
B = 1


Example Output
Output 1:

[3, 4, 1, 2]
Output 2:

[6, 2, 5]


Example Explanation
Explanation 1:

Rotate towards the right 2 times - [1, 2, 3, 4] => [4, 1, 2, 3] => [3, 4, 1, 2]
Explanation 2:

Rotate towards the right 1 time - [2, 5, 6] => [6, 2, 5]

 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q3_ArrayRotation {

    public static ArrayList<Integer> reverseArrayInRange(ArrayList<Integer> A ,int st, int B){
        int start = st;
        int end = B;
        while(start<end){
            int temp =A.get(start);
            A.set(start,A.get(end));
            A.set(end,temp);
            start++;
            end--;
        }
        return A;
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        int rotate = B%A.size();
        reverseArrayInRange(A, 0, A.size()-1);
        reverseArrayInRange(A, 0, rotate-1);
      return  reverseArrayInRange(A, rotate, A.size()-1);
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,1,4,9,4,7,1));
        int B=9;
        System.out.println(solve(arrayList, B));
    }
}


