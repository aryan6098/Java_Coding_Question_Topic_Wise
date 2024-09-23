/*
 * Q2. Count of divisors

 */

import java.util.ArrayList;
import java.util.Arrays;

public class Q2_CountOfDivisors {

    public static ArrayList<Integer> countDivisors(int A) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int  i = 0; i <= A; i++) {
            arrayList.add(0);
        }
        for(int i = 1; i <= A; i++) {
           for(int j = i; j <= A; j = j + i) {
            arrayList.set(j, arrayList.get(j) + 1);
           }
        }
        return arrayList;
    }
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        int maxElement = 0;
        for (int i = 0; i < A.size(); i++) {
            maxElement = Math.max(maxElement, A.get(i));
        }

        ArrayList<Integer> countOfDivIntegers = countDivisors(maxElement);

        for(int i = 0; i < A.size(); i++) {
            result.add(countOfDivIntegers.get(A.get(i)));
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(2, 3, 4, 5));
        System.out.println(solve(arrayList));
    }
}
