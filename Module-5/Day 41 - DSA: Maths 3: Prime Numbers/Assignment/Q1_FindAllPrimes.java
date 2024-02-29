import java.util.ArrayList;

public class Q1_FindAllPrimes {

    public static boolean isPrime(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                if (i == n / i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        if (count == 2) {
            return true;
        } else {
            return false;
        }
    }

    // first Method
    // public static ArrayList<Integer> solve(int A) {
    //     ArrayList<Integer> arrayList = new ArrayList<>();
    //     for(int i = 1; i <= A; i++) {
    //         if(isPrime(i) == true) {
    //             arrayList.add(i);
    //         }
    //     }
    //     return arrayList;
    // }

    // Second Method
    public static ArrayList<Integer> solve(int A) { 
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Boolean> arrayList = new ArrayList<>();
        for(int i = 0; i < A + 1; i++) {
            arrayList.add(true);
        }
        arrayList.set(0, false);
        arrayList.set(1, false);

        for(int i = 2; i * i <= A; i++) {
            if(arrayList.get(i) == true) {
                for(int j = i * i; j <= A; j = j + i) {
                    arrayList.set(j, false);
                }
            }
        }
        for(int i = 2; i < arrayList.size(); i++) {
           if(arrayList.get(i) == true) {
            result.add(i);
           }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solve(7));
    }
}
