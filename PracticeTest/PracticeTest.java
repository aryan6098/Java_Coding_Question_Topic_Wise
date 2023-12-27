import java.util.ArrayList;

public class PracticeTest {

    public static int solve(ArrayList<Integer> A){
       int count = 0;
       int max = Integer.MIN_VALUE;

       int maxIndex= 0;
       
       int secondMax= Integer.MIN_VALUE;
        for(int i=0;i<A.size();i++){
            if(A.get(i)>max){
                max= A.get(i);
        maxIndex = i;
            }
        }
        for(int i=0;i<A.size();i++){
            if(A.get(i)>secondMax && maxIndex!=i){
                secondMax = A.get(i);
            }
        }
       return (max + secondMax);
    }

    public static int increasing(ArrayList<Integer> arrayList){
        for (int i = 0; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i) > arrayList.get(i + 1)) {
                return 0; 
            }
        }
        return 1; // Strictly increasing
    }
    public static int twoSum(ArrayList<Integer> arrayList, int B){
         for (int i = 0; i < arrayList.size() ; i++) {
           for(int j=i+1;j<arrayList.size();j++){
            if(arrayList.get(i)+arrayList.get(j)==B){
                return 1;
            }
           }
        }
        return 1;
    }

    public static ArrayList<Integer> reverseArray(ArrayList<Integer> arrayList ){
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.addAll(arrayList);
        int start = 0;
        int end =arrayList.size()-1;
        while(start<end){
            int temp = arrayList.get(start);
            arrayList.set(start, arrayList.get(end));
            arrayList.set(end,temp);
            start++;
            end--;
        }
        return arrayList;

    }

    public static void checkLexicographically(String str1, String str2){
        String  isLexicographically = "Yes";
        int minLength = Math.min(str1.length(), str2.length());
        System.out.println("Compare: "+ str1.compareTo(str2));
        // System.out.print(Str1.length()+ B.length());
        for(int i =0; i<minLength;i++){
                if(str1.charAt(i)< str2.charAt(i)){
                    isLexicographically= "No";
                    break;
                }
               
        }
        System.out.println(isLexicographically);
    }
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        // arrayList.add(9);
        // arrayList.add(18);
        // arrayList.add(17);
        // arrayList.add(17);
        //   arrayList.add(6);
        //    arrayList.add(16);
        // arrayList.add(13);
        // arrayList.add(11);
        //   arrayList.add(15);
        //        arrayList.add(7);

        arrayList.add(2);
        arrayList.add(2);
        arrayList.add(1);
        arrayList.add(4);
        //   arrayList.add(6);
        //    arrayList.add(7);
        // arrayList.add(8);
        // arrayList.add(17);
        //   arrayList.add(13);
        //        arrayList.add(7);
        // System.out.println(increasing(arrayList));
        // System.out.println(twoSum(arrayList, 7));
       reverseArray(arrayList);
        // System.out.println(arrayList);

        // checkLexicographically("apple", "orange");
        String A = "HEllo";
        String str = "";
        for(int i =0;i<A.length();i++){
            str = A.charAt(i)+ str;
        }
        System.out.println(str);
        if(A.equals(str)){
            System.out.print("Yes");
        }else {
            System.out.print("No");
        }
    }
}
