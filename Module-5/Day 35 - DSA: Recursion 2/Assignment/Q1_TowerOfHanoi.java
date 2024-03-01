/*
 * Q1. Tower of Hanoi

 */

import java.util.ArrayList;

public class Q1_TowerOfHanoi {

    public static void tOH(int n, int A , int B, int C, ArrayList<ArrayList<Integer>> result) {
        if(n == 0) {
            return;
        }
        tOH(n - 1, A, C, B, result);
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(n);
        arrayList.add(A);
        arrayList.add(C);
        result.add(arrayList);
        tOH( n - 1, B, A, C, result);

    }

    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

      tOH(A, 1, 2 , 3, result);
      return result;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> result  =  towerOfHanoi(2);
        for (ArrayList<Integer> move : result) {
            System.out.print(move + " ");
        }
    }
}
