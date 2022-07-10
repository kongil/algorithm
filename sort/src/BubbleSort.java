import java.util.*;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6,3,1,2,3,5,7,9};
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        for (int ar : arr) {
            System.out.println("ar = " + ar);
        }
    }
}
