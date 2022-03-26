import java.util.Arrays;
import java.util.Scanner;

public class Ex3_2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n, m, k를 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int sum = 0;

        int first = arr[n-1];
        int second = arr[n-2];

        sum += first * (m - m % k);
        sum += second * (m % k);

        System.out.println(sum);
    }
}
