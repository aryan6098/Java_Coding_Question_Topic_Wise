import java.util.HashMap;
import java.util.HashSet;

public class CheckPairWithGivenSum {
    public static boolean pairSum(int[] A, int k) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            int x = A[i];
            int y = k - A[i];
            if (hashSet.contains(y) == true) {
                System.out.println(x + " " + y);
                return true;
            }
            hashSet.add(A[i]);
        }
        return false;
    }

    public static void printFreq(int[] A) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < A.length; i++){
            hashMap.put(A[i], hashMap.getOrDefault(A[i], 0) + 1);
        }

        int st = 1; int end = k;
        while (end < A.length) {
            
        }
        for(int val : hashMap.keySet()) {
            System.out.println(val + " " + hashMap.get(val) );
        }

    }

    public static void main(String[] args) {
        int[] A = { 8, 9, 2, -2, 4, 4, 2, -6, 4 };
        // System.out.println(pairSum(A, 2));
        System.out.println();
        printFreq(A);
    }
}
