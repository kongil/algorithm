import java.util.Scanner;

public class Ex8_2 {
    public static int[] dp = new int[100000];
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) return 1;

        if (dp[n] != 0) return dp[n];

        return (dp[n] = fibonacci(n - 1) + fibonacci(n - 2));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(fibonacci(n));
    }
}
