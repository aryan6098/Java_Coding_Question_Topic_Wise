import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class k_sortedList {

    static class Pair {
        int val;
        int arrayIndex;
        int elementIndex;

        public Pair(int val, int arrayIndex, int elementIndex) {
            this.val = val;
            this.arrayIndex = arrayIndex;
            this.elementIndex = elementIndex;
        }
    }

    public static ArrayList<Integer> kSortedList(ArrayList<ArrayList<Integer>> arrList) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.val - a.val);

        for (int i = 0; i < arrList.size(); i++) {
            if (!arrList.get(i).isEmpty()) {
                pq.add(new Pair(arrList.get(i).get(0), i, 0));
            }
        }

        System.out.println("pq" + pq);

        return list;

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        // lists.add(new ArrayList<>()); // Empty list
        lists.add(new ArrayList<>(Arrays.asList(1, 2)));
        lists.add(new ArrayList<>(Arrays.asList(2, 5, 8)));
        lists.add(new ArrayList<>(Arrays.asList(3, 6, 9)));
        kSortedList(lists);

    }
}
