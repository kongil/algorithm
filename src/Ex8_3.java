import java.util.*;

public class Ex8_3 {
    public static int[] dp = new int[100000];

    public static int fibonacci(int n) {
        for (int i = 1; i <= n; i++) {
           if (i == 1 || i == 2) dp[i] = 1;
           else dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }
}
