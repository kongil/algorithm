import java.util.*;

public class Ex3_2 {
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

        int cnt = 0;
        int sum = 0;
        while (m > 0) {
            if (cnt < k) {
                cnt++;
                sum += arr[n-1];
            }
            else {
                sum += arr[n-2];
                cnt = 0;
            }

            m--;
        }

        System.out.println(sum);
    }
}
