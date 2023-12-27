import java.util.ArrayList;
import java.util.Arrays;

public class Q5_MaxMinOfAnArray {

public static int solve(ArrayList<Integer> A) {
       int max = Integer.MIN_VALUE;
       int min = Integer.MAX_VALUE;
       for(int i = 0;i < A.size(); i++){
        if(A.get(i)>max){
            max = A.get(i);
        }
         if(A.get(i)<min){
            min = A.get(i);
        }
       }
       return (max + min);
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,5,9));
        System.out.println(solve(arrayList));
    }
}
