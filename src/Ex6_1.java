import java.util.Scanner;

public class Ex6_1 {

    public static int arr[] = {7,5,9,0,3,1,6,2,4,8};

    public static void main(String[] args) {
        // 선택 정렬
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            int min_index = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min_index]) {
                    min_index = j;
                }
            }
            int tmp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = tmp;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
