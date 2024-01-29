import java.util.ArrayList;
import java.util.Arrays;

public class ClasseProbelm {

    public static void printMatricesRowWise(int[][] arr) {
        for(int i= 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void printMatricesColumnWise(int[][] arr){
        System.out.println();
        for(int i =0; i < arr[0].length; i++){
            for(int j = 0; j < arr.length; j++){
                System.out.print(arr[j][i]+ " ");
            }
            System.out.println();
        }
    }
    public static void sumRowWise(int[][] arr){
        
        for(int i= 0; i < arr.length; i++){
            int sum = 0;
            for(int j = 0; j < arr[0].length; j++){
                sum += arr[i][j];
            }
            System.out.println(sum);
        }
       
    }
    public static void sumColumnWise(int[][] arr){
        System.out.println();
        for(int i =0; i < arr[0].length; i++){
            int sum = 0;
            for(int j = 0; j < arr.length; j++){
               sum += arr[j][i];
            }
            System.out.println(sum);
        }
      
    }

    public static void diagonalSum(int[][] A){
        System.out.println();
        int i = 0,j = 0;
        int sum = 0;
        while(i < A.length && j  < A[0].length){
            sum += A[i][j];
            i++;
            j++;
        }
        System.out.println("Diagonal Sum: "+sum);
    }

    public static void printDiagonalRightToLeft(int[][] A){
        int row = A.length;
        int column = A[0].length;
        // int[][] arr = new int[2*row-1][column]
        for(int c =0 ;c < column; c++)  {
            int i = 0;int j = c;
            while (i < row && j >= 0) {
                System.out.print(A[i][j] +" ");
                
                i++;
                j--;
            }
            System.out.println();
        }
        for(int c =1 ;c < row; c++)  {
            int i = c;int j = column-1;
            while (i < row && j >= 0) {
                System.out.print(A[i][j] +" ");
                i++;
                j--;
            }
            System.out.println();
        }
        
    }
    public static ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for (int c = 0; c < A.get(0).size(); c++) {
            int i = 0;
            int j = c;
            ArrayList<Integer> arr = new ArrayList<>();
            while (i < A.size() && j >= 0) {
                arr.add(i, A.get(i).get(j));
                i++;
                j--;
            }
            
            while (i < A.size()) {
                arr.add(0);
                i++;
            }
            arrayList.add(arr);
        }
        for (int c = 1; c < A.size(); c++) {
            int i = c;
            int j = A.get(0).size() - 1;
            ArrayList<Integer> arr = new ArrayList<>();
            while (i < A.size() && j >= 0) {
                arr.add(A.get(i).get(j));
                i++;
                j--;
            }
            while (j >= 0) {
                arr.add(0);
                j--;
            }
            arrayList.add(arr);
        }
        return arrayList;
    }
    

    public static void transposeMatrix1(int[][] A){
        int[][] result = new int[A[0].length][A.length];
        for(int i = 0; i < A.length; i++){
            for(int j = 0;j< A.length;j++){
                result[j][i]= A[i][j];
            }
        }
        for(int i = 0; i< result.length;i++){
            for(int j = 0;j < result[0].length;j++){
                System.out.print(result[i][j]+ " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
            // {12,3,4,5},
        };

        // printMatricesRowWise(arr);
        // printMatricesColumnWise(arr);
        // sumRowWise(arr);
        // sumColumnWise(arr);
        // diagonalSum(arr);
        printDiagonalRightToLeft(arr);

        System.out.println("-----------");
        ArrayList<ArrayList<Integer>> twoDArrayList = new ArrayList<>() {{
            add(new ArrayList<>(Arrays.asList(1, 2, 3)));
            add(new ArrayList<>(Arrays.asList(4, 5, 6)));
            add(new ArrayList<>(Arrays.asList(7, 8, 9)));
        }};
        ArrayList<ArrayList<Integer>> result = diagonal(twoDArrayList);
        System.out.println(result);
        transposeMatrix1(arr);
    }
    
}
