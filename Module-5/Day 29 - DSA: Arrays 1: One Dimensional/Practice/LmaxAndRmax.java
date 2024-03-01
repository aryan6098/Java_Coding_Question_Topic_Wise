public class LmaxAndRmax {
    public static void lmaxAndRmax(int A[]) {
        int lMax[] = new int[A.length];
        lMax[0] = A[0];
        int rMax[] = new int[A.length];
        rMax[A.length - 1] = A[A.length - 1];
        for (int i = 1; i < A.length; i++) {
            lMax[i] = Math.max(lMax[i - 1], A[i]);
        }
         for (int i = A.length - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], A[i]);
        }
        int sum = 0; 
        for(int  i = 0; i < A.length; i++)
        {
            int min  = Math.min(lMax[i], rMax[i]);
            int height = min - A[i];
            sum += height;
        }
        System.out.println(sum);
       

        // for (int i = 0; i < rMax.length; i++) {
        //     System.out.print(rMax[i] + " ");
        // }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 2,5,7,4,2,3,6,8,2,3 };
        lmaxAndRmax(arr);
    }
}
