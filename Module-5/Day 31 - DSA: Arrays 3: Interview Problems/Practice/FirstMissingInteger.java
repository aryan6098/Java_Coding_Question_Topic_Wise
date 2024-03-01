import java.util.ArrayList;
import java.util.Arrays;

public class FirstMissingInteger {


    // Brute Force Approach  -> O(n2)
    public static int firstMissingPositive(ArrayList<Integer> A) {
        int count = 1;
        for(int i = 0; i < A.size(); i++) {
            for(int j = 0; j < A.size(); j++){
                if(count == A.get(j)){
                    count++;
                    continue;
                }
            }
        }
        return count;
    }

    // using Sorting Method  -> n(logn)
    public static int firstMissingPositive2(ArrayList<Integer> A) {
        A.sort(null);
        int count = 1;
        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) < 1) {
                continue;
            }
            if(A.get(i) == count){
                count++;
            }
            else if(A.get(i) == A.get(i-1)) {
                continue;
            }
            else {
                break;
            }
        }
        return count;
    }

    public static int firstMissingPositive3(ArrayList<Integer> arrayList) {
        for(int i = 0; i < arrayList.size(); i++) {
            if(arrayList.get(i) <= 0) {
                arrayList.set(i, arrayList.size()+2);
            }
        }
        for(int i = 0; i < arrayList.size(); i++){
            int ele = Math.abs(arrayList.get(i));
            int idx = ele -1;
            if(idx < arrayList.size()) {
                int val = arrayList.set(idx, -1 *Math.abs(arrayList.get(idx)));
            }
        }
          

        for(int i = 0; i < arrayList.size(); i++) {
          if(arrayList.get(i) > 0) {
            return i + 1;
          }
        }
        int n = arrayList.size();
        return(n + 1);
    }





    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(-8, -7, -6));
        // System.out.println(firstMissingPositive(arrayList));
        // System.out.println(firstMissingPositive2(arrayList));
        System.out.println(firstMissingPositive3(arrayList));    
    }
}
