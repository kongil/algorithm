import java.util.*;

public class Ex7_8 {
    public static int getSum(int[] arr, int len) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > len) {
                sum += arr[i]-len;
            }
        }
        return sum;
    }
    public static int binarySearch(int[] arr, int target, int start, int end) {
        int result = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int alphas = getSum(arr, mid);

            if (alphas < target) {
                end = mid-1;
            }
            else if (alphas >= target) {
                start = mid+1;
                result = mid;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = binarySearch(arr, m, 0, 2000000001);
        System.out.println(result);
    }
}
