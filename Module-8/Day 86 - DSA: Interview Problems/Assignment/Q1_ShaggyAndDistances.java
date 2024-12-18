import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Q1_ShaggyAndDistances {

    public static int solve(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < A.size(); i++) {
            if(map.containsKey(A.get(i))) {
                int index = map.get(A.get(i));
                ans = Math.min(ans, i - index + 1);
                map.put(A.get(i), i + 1);
            }else {
                map.put(A.get(i), i + 1);
            }
        }

        if(ans == Integer.MAX_VALUE) {
            return  -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Answer: " + solve(new ArrayList<Integer> (Arrays.asList(1, 1))));
    }
}