/*
 * Q2. Print paths in Staircase

 */

import java.util.ArrayList;

public class Q2_PrintPathsInStaircase {
    static int count = 0;
    public static void generateWaysToClimb(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> currentPath,
            int target, int step) {
        if (step == target) {
            count++;
            result.add(new ArrayList<>(currentPath));
            return;
        }
        if (step + 1 <= target) {
            currentPath.add(1);
            generateWaysToClimb(result,currentPath,  target, step + 1);
            currentPath.remove(currentPath.size() - 1); // Backtrack after recursion
        }
        if (step + 2 <= target) {
            currentPath.add(2);
            generateWaysToClimb(result,currentPath,target, step + 2);
            currentPath.remove(currentPath.size() - 1); // Backtrack after recursion
        }
    }

    public static ArrayList<ArrayList<Integer>> WaysToClimb(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        generateWaysToClimb(result, new ArrayList<>(), A, 0 );

        return result;
    }

    public static void main(String[] args) {

       System.out.println(WaysToClimb(2));
       System.out.println(count);
    }
}
