import java.util.ArrayList;

public class Q2_BuildAHeap {

   public static ArrayList<Integer> heap = new ArrayList<>();

    public static void addVal(int val) {
        heap.add(val);
        int i = heap.size() - 1;
        while (i > 0) {
            int pi = (i - 1) / 2;
            if (heap.get(pi) > heap.get(i)) {
                int temp = heap.get(i);
                heap.set(i, heap.get(pi));
                heap.set(pi, temp);
                i = pi;
            } else {
                break;
            }
        }
    }



    public static int[] buildHeap(int[] A) {

        heap.clear();
        for (int i = 0; i < A.length; i++) {
            addVal(A[i]);
        }
        int[] heapArray = new int[heap.size()];
        for(int i = 0 ; i < heap.size(); i++) {
            heapArray[i] = heap.get(i);
        }
        return heapArray;
    }

    public static void main(String[] args) {
        int[] A = {5,1,1,2,0,0};
        int[] res = buildHeap(A);
        // for(int i = 0; i < res.length; i++) {
        //     System.out.println(res[i] + " ");
        // }

        ArrayList<Integer> heap1 = new ArrayList<>();
        heap1.add(1);
        heap1.add(1);
        heap1.add(1);

        System.out.println(heap1.size()-1);


    }
}
