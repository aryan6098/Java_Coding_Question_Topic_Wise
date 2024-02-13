/*
 * Q4. Number of 1 Bits

 */
public class Q4_NumberOf1Bits {
    
    public static boolean checkBit(int n ,int i) 
    {
        if((n & (1 << i)) > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public static int numSetBits(int A) {
        int count = 0;
        for(int  i = 0; i < 32; i++) {
            if(checkBit(A, i) == true) {
                count++;
            }
        }
        return count;

    }
    public static void main(String[] args) {
        System.out.println(numSetBits(10));
    }
}
