import java.util.*;

// 선택정렬
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {6,3,1,2,3,5,7,9};
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIdx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }

        for (int i = 0; i < n; i++) {
            System.out.println("i = " + i);
            System.out.println("arr[i] = " + arr[i]);
        }
    }
}
