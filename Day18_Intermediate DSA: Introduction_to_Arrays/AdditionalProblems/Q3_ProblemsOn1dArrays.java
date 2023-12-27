/*Q3. Problems on 1D Arrays-2 MCQ D

What will be the output of the following code?

Options: 

    40
    30
    98
    Error

 */
public class Q3_ProblemsOn1dArrays {
     static void fun(int[] arr) { 
        arr[3] = 98;
        return;
    }
    public static void main(String[] args) {
        int[] arr  = {10,20,30,40,50};
        fun(arr);
        System.out.println(arr[3]);
    }
}
