/*
 * Q3. Anti Diagonals
Problem Description
Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.


Problem Constraints
1<= N <= 1000
1<= A[i][j] <= 1e9


Input Format
Only argument is a 2D array A of size N * N.


Output Format
Return a 2D integer array of size (2 * N-1) * N, representing the anti-diagonals of input array A.
The vacant spaces in the grid should be assigned to 0.


Example Input
Input 1:
1 2 3
4 5 6
7 8 9
Input 2:

1 2
3 4


Example Output
Output 1:
1 0 0
2 4 0
3 5 7
6 8 0
9 0 0
Output 2:

1 0
2 3
4 0


Example Explanation
For input 1:
The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
The third anti diagonal of the matrix is [3, 5, 7 ], the rest spaces shoud be filled with 0 making the row as [3, 5, 7].
The fourth anti diagonal of the matrix is [6, 8 ], the rest spaces shoud be filled with 0 making the row as [6, 8, 0].
The fifth anti diagonal of the matrix is [9 ], the rest spaces shoud be filled with 0 making the row as [9, 0, 0].
For input 2:

The first anti diagonal of the matrix is [1 ], the rest spaces shoud be filled with 0 making the row as [1, 0, 0].
The second anti diagonal of the matrix is [2, 4 ], the rest spaces shoud be filled with 0 making the row as [2, 4, 0].
The third anti diagonal of the matrix is [3, 0, 0 ], the rest spaces shoud be filled with 0 making the row as [3, 0, 0].
 */

import java.util.*;
public class Q3_AntiDiagonals {

    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int c = 0; c < A.get(0).size(); c++) {
            int i = 0;
            int j = c;
            ArrayList<Integer> arr = new ArrayList<>();
            while (i < A.size() && j >= 0) {
                arr.add(i, A.get(i).get(j));
                i++;
                j--;
            }

            while (i < A.size()) {
                arr.add(0);
                i++;
            }
            arrayList.add(arr);
        }
        for (int c = 1; c < A.size(); c++) {
            int i = c;
            int j = A.get(0).size() - 1;
            ArrayList<Integer> arr = new ArrayList<>();
            while (i < A.size() && j >= 0) {
                arr.add(A.get(i).get(j));
                i++;
                j--;
            }
            while (j >= 0) {
                arr.add(0);
                j--;
            }
            arrayList.add(arr);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        // int[][] arr = {
        // { 1, 2, 3, 4 },
        // { 5, 6, 7, 8 },
        // { 9, 10, 11, 12 },
        // { 13, 14, 15, 16 },
        // };
        // System.out.println(diagonal(arr));
        ArrayList<ArrayList<Integer>> twoDArrayList = new ArrayList<>() {
            {
                add(new ArrayList<>(Arrays.asList(1, 2, 3)));
                add(new ArrayList<>(Arrays.asList(4, 5, 6)));
                add(new ArrayList<>(Arrays.asList(7, 8, 9)));
            }
        };
        ArrayList<ArrayList<Integer>> result = diagonal(twoDArrayList);
        System.out.println(result);

    }
}
