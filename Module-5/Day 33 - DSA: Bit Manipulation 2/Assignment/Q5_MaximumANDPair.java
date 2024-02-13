import java.util.ArrayList;
import java.util.Arrays;

public class Q5_MaximumANDPair {
    public static int solve(ArrayList<Integer> A) {
        int ans = 0;
        for (int i = 0; i < A.size(); i++) {
            int max = 0;
            for (int j = i + 1; j < A.size(); j++) {
                int val = A.get(i) & A.get(j);
                if (val > ans) {
                    ans = val;
                }
            }
        }
        return ans;
    }
 
    public static int solveMethod1(ArrayList<Integer> A) {

        int ans = 0;
        for(int i = 31; i >= 0; i--) {
            int count = 0;
            for(int j = 0; j < A.size(); j++) {
                if((A.get(j) & (1 << i)) > 0) {
                    count++;
                }
            }
            if(count >= 2) {
                ans =( ans | (1 << i));
                for(int j = 0; j < A.size(); j++) {
                    if((A.get(j) & (1 << i)) == 0) {
                        A.set(j, 0);
                    }
                }
                
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(38, 44, 84, 12));
        System.out.println(solve(arrayList));
        System.out.println(solveMethod1(arrayList));
    }

}
