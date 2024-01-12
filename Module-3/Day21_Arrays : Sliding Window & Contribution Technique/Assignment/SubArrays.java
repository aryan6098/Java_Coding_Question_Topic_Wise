public class SubArrays {
    public static void main(String[] args) {
        int arr[] = {12,13,14,15,16};
        int k =3;
        int st = 0;
        int end = k-1;
        while (end<arr.length) {
            // for(int  i = st; i <= end ;i++) {
            // System.out.print(arr[i]+ " ");
            // }
            // System.out.println();
            System.out.println(st + " : "+ end);
            st++;
            end++;
        }
    }
}
