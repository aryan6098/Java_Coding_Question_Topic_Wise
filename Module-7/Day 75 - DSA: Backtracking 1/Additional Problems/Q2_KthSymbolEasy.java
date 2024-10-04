/*
 * Q2. Kth Symbol - Easy
 */

import java.util.ArrayList;

public class Q2_KthSymbolEasy {

    public static ArrayList<Integer> generateKthRow(int A) {
        ArrayList<Integer> currentRow = new ArrayList<>();
        if(A == 1) {
            currentRow.add(0);
            return currentRow;
        }
        ArrayList<Integer> previousRow = generateKthRow(A- 1);

        for(int i = 0; i < previousRow.size(); i++) {
            if(previousRow.get(i) == 0) {
                currentRow.add(0);
                currentRow.add(1);
            }else {
                currentRow.add(1);
                currentRow.add(0);                
            }
        }
        return currentRow;

    }

    public static int solve(int A, int B) {
        ArrayList<Integer> row = generateKthRow(A);
        System.out.println(generateKthRow(A));
        return 0;

    }

    public static void main(String[] args) {
           int result = solve(1, 1); // A=3, B=2 means we're looking for the 2nd symbol in the 3rd row
        System.out.println(result);
    }
}
