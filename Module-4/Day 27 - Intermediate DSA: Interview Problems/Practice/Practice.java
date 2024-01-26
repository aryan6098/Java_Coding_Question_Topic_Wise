public class Practice {

    public static int solve(int[] arr) {

        int ans = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }
        }
        if (count == 0) {
            return arr.length;
        }
        if (count == arr.length) {
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int l = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[j] == 1) {
                        l++;
                    } else {
                        break;
                    }
                }
                int r = 0;
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] == 1) {
                        r++;
                    } else {
                        break;
                    }
                }
                if (l + r + 1 > ans) {
                    ans = l + r + 1;
                }

            }
        }
        return ans;
    }

    public static void majorityElement(int[] arr) {
        int mE = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == mE) {
                count++;
            } else if (arr[i] != mE && count == 0) {
                mE = arr[i];
                count = 1;
            } else {
                count--;
            }
        }
        System.out.println(mE);
    }

    public static void main(String[] args) {
        // int[] arr = { 1, 1, 1, 0, 0, 0 };
        // System.out.println(solve(arr));

        int majorityElement[] = {4, 3, 3, 5, 3, 5, 3};
        majorityElement(majorityElement);
    }
}
