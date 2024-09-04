import java.util.Arrays;

public class Q2_TensDigitSorting {
    public static int compare(int a, int b) {

        int mod1 =  Math.abs((a / 10) % 10);
        int mod2 = Math.abs((b / 10) % 10);

        if (mod1 != mod2) {
            return Integer.compare(mod1, mod2);
        }
        return Integer.compare(b, a);
    }

    public static int[] sortByTensDigit(int[] arr) {

        Integer[] arr1 = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(arr1, (a, b) -> compare(a, b));
        return Arrays.stream(arr1).mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] A = { 15, 11, 7, 19 };
        int[] result = sortByTensDigit(A);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
