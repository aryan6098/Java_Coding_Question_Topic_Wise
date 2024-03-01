public class SmallestPrimeFactors {
    public static int[] smallestPrimeFactors(int n ) {
        int[] spf = new int[n + 1];

        for(int i = 2 ; i <= n; i++) {
            spf[i] = i;
        }

        for(int i = 2; i * i <= n; i++) {
            if(spf[i] == i) {
                for(int j = i * i; j <= n; j = j + i) {
                    if(spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        return spf;
    }
    public static void main(String[] args) {
        int n = 10;
       int[] res =  smallestPrimeFactors(n);
       for(int i = 2; i < res.length; i++ ){
        System.out.print(res[i] + " ");
       }

    }
}
