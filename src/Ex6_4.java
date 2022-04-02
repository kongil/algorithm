import java.util.Scanner;

// 퀵 정렬
public class Ex6_4 {

    static int arr[] = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

    public static void quickSort(int arr[], int start, int end) {
        if (start >= end) return; // 원소가 1개인 경우 종료
        int pivot = start;
        int left = start+1;
        int right = end;

        while (left <= right) {
            // 왼쪽부터 피벗보다 큰 데터를 찾을 때까지 반복
            while (left < end && arr[left] <= arr[pivot]) left++;
            // 오른쪽부터 피벗보다 작은 데터를 찾을 때까지 반복
            while (right > start && arr[right] >= arr[pivot]) right--;

            // 엇갈리지 않았따면 작은 데이터와 큰 데이터 교체
            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
            // 엇갈렸다면 피벗 데이터와 작은 데이터 교체
            else {
                int tmp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = tmp;
            }
        }

        // 분할 이후 큰쪽과 작은쪽에서 각 정렬 수행
        quickSort(arr, start, right-1);
        quickSort(arr, right+1, end);
    }

    public static void main(String[] args) {
        quickSort(arr, 0, arr.length - 1);
        for (int x : arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

}