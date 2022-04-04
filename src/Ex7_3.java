import java.util.*;

// 이진 탐색 소스코드 구현(반복문)
public class Ex7_3 {
    public static int binarySearch(int[] arr, int target, int start, int end) {
        int mid = (start + end) / 2;

        while (start <= end) {
            if (arr[mid] == target) {
                return mid+1;
            }
            else if (arr[mid] < target) {
                start = mid+1;
            }
            else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = binarySearch(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        }
        else {
            System.out.println(result);
        }

    }

}
