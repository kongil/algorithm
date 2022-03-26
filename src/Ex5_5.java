public class Ex5_5 {
    public static int factorial_iterative(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public static int factorial_recursive(int n) {
        if (n == 2) return n;

        return n * factorial_recursive(n-1);
    }
    public static void main(String[] args) {
        System.out.println(factorial_iterative(3));
        System.out.println(factorial_recursive(3));
    }
}
