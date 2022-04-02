import java.util.Scanner;

// 삽입 정렬
public class Ex6_3 {
    static int arr[] = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
                else break;
            }
        }

        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();

    }
}
