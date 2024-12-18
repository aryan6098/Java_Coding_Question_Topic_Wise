public class Q4_MeetingRoomsII {

    public static int solve(int A, int[][] B) {

        int[] arr = new int[1000000];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < B.length; i++ ){
            int st = B[i][0];
            int end = B[i][1];
            arr[st] += 1;
            arr[end] -= 1;
        }
        for(int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i-1];
        }

        for(int i = 0 ; i < arr.length; i++ ){
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = { {0, 1}};
        System.out.println(solve(3, arr));
    }
}