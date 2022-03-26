import java.util.Scanner;

public class Ex3_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int cnt = 0;
        while (n != 1) {
            if (n % k == 0) {
                n /= k;
            }
            else {
                n--;
            }
            cnt++;
        }

        System.out.println(cnt);

    }
}
