/*
 * Q3. Print All Maze Paths

 */

import java.util.ArrayList;

public class Q3_PrintAllMazePaths {
    static int count = 0;

    // public static void generateAllPath(ArrayList<String> result, int i, int j,
    // int row, int col,
    // String ans) {
    // if(i == row && j == col) {
    // result.add(ans);
    // return;
    // }
    // if (i + 1 <= row) {
    // generateAllPath(result, i+1, j, row, col, ans+"D");
    // }
    // if (j + 1 <= col) {
    // generateAllPath(result, i, j + 1, row, col, ans+"R");
    // }

    // }

    public static void generateAllPath( int i, int j, int row, int col) {
        if(i == row && j == col) {
            count++;
                return;
        }
        if (i + 1 <= row) {
            generateAllPath(i+1, j, row, col);
        }
        if (j + 1 <= col) {
            generateAllPath(i, j + 1, row, col);
        }

        }

    public static int printAllPaths(int A, int B) {
        ArrayList<String> result = new ArrayList<>();
        generateAllPath(0, 0, A - 1, B - 1);
        System.out.println(count);
        return count;

    }

    public static void main(String[] args) {
        System.out.println(printAllPaths(3, 2));

    }
}
