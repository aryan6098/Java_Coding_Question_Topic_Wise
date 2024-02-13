/*
 * Q1. Next Permutation
Problem Description
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.

If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.

NOTE:

The replacement must be in-place, do not allocate extra memory.
DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.

Problem Constraints
1 <= N <= 5 * 105

1 <= A[i] <= 109

Input Format
The first and the only argument of input has an array of integers, A.


Output Format
Return an array of integers, representing the next permutation of the given array.


Example Input
Input 1:
 A = [1, 2, 3]

Input 2:
 A = [3, 2, 1]

 */
import java.util.ArrayList;
import java.util.Arrays;

public class Q1_NextPermutation {

    public static void swap(ArrayList<Integer> A, int idx) {
        int st = idx + 1;
        int end = A.size() - 1;
        while (st < end) {
            int temp = A.get(st);
            A.set(st, A.get(end));
            A.set(end, temp);
            st++;
            end--;
        }
    }

    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {

        int idx = -1;
        for (int i = A.size() - 2; i >= 0; i--) {
            if (A.get(i) < A.get(i + 1)) {
                idx = i;
                break;
            }
        }

        if(idx != -1) {
            for (int i = A.size() - 1; i >= idx; i--) {
                if (A.get(i) > A.get(idx)) {
    
                    int temp = A.get(i);
                    A.set(i, A.get(idx));
                    A.set(idx, temp);
                    break;
                }
            }
        }
        swap(A, idx);
        return A;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(3, 2, 1));
        nextPermutation(arrayList);
        System.out.println(arrayList);
    }
}
