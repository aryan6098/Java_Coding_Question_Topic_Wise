/*
 * Q2. Permutations

 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q2_Permutations {

    public static void generatePermutation(ArrayList<Integer> arr, ArrayList<Integer> A, int idx,
            ArrayList<Boolean> visited, ArrayList<ArrayList<Integer>> result) {

        if (idx == arr.size()) {
            ArrayList<Integer> permutation = new ArrayList<>(arr);
            result.add(permutation);
            return;
        }

        for (int i = 0; i < A.size(); i++) {
            if (visited.get(i) == false) {
                visited.set(i, true);
                arr.set(idx, A.get(i));
                generatePermutation(arr, A, idx + 1, visited, result);
                visited.set(i, false);
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> arr = new ArrayList<>(A);
        ArrayList<Boolean> visited = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            visited.add(false);
        }
        generatePermutation(arr, A, 0, visited, result);
        return result;

    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3));
        System.out.println(permute(arrayList));
    }
}
