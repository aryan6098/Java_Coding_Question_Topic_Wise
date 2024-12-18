import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Q2_ProductOf3 {
    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b- a);
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            pq.add(A.get(i));
            if (i < 2) {
                result.add(-1);
            }else {
                int a = pq.poll();
                int b = pq.poll();
                int c = pq.poll();;
                result.add(a * b * c);
                pq.add(a);
                pq.add(b);
                pq.add(c);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(10, 2, 13, 4));
        System.out.println(solve(A));
    }
}
