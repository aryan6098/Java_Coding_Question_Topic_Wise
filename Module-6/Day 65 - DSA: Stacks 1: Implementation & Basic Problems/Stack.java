import java.util.ArrayList;

public class Stack {
    public static void push(ArrayList<Integer> arrayList,int val) {
        arrayList.add(val);
    }
    public static void pop(ArrayList<Integer> arrayList) {
        if (!arrayList.isEmpty()) {
            arrayList.remove(arrayList.size() - 1);
        }
    }
    public static int peak(ArrayList<Integer> arrayList) {
      if(!arrayList.isEmpty()) {
        return arrayList.get(arrayList.size() - 1); 
      }
      else {
        throw new IllegalStateException("Stack is empty");
    }
    }
    public static boolean isEmpty(ArrayList<Integer> arrayList) {
        return arrayList.isEmpty();
    }

    public static void main(String[] args) {
        ArrayList<Integer> stack = new ArrayList<>();
        push(stack, 10);
        push(stack, 20);
        System.out.println(stack);
        System.out.println("Top element: " + peak(stack));
        pop(stack);
        System.out.println("Is stack empty? " + isEmpty(stack)); 
    }
}
