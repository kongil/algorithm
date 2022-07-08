import java.util.*;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {6,3,1,2,3, 4, 3, 2, 1,5,7,9};
        int n = arr.length;
        // 2번째 값부터 시작해 그 앞에 존재하는 원소들과 비교하며 삽입할 위치를 찾아 삽입하는 정렬 알고리즘입니다
        // 앞에 존재하는 원소들은 정렬되어 있게 된다.
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j-1] > arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
                else {
                    break;
                }
            }
        }

        for (int ar : arr) {
            System.out.println("ar = " + ar);
        }

    }
}
