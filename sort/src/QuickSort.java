import java.util.*;

public class QuickSort {
    public static void quickSort(int[] arr, int start, int end) {
        // 더 이상 반복할 수 없다면 종료
        if (end <= start) return;
        int pivot = start; // 호어 방식 - 맨 앞의 값을 피벗으로 뽑음
        int left = start+1;
        int right = end;
        while (left <= right) {
            // left가 pivot의 값보다 큰 경우를 찾을때까지 반복
            while (left < end && arr[left] <= arr[pivot]) left++;

            // right가 pivot의 값보다 작은 경우를 찾을때까지 반복
            while (start < right && arr[right] >= arr[pivot]) right--;

            if (left < right) {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
            else {
                int tmp = arr[right];
                arr[right] = arr[pivot];
                arr[pivot] = tmp;
            }
        }

        // 피벗을 제외하고 왼쪽 부분배열 반복
        quickSort(arr, start, right-1);

        // 피벗을 제외하고 오른쪽 부분배열 반복
        quickSort(arr, right+1, end);
    }
    public static void main(String[] args) {
        int[] arr = {6,3,1,2,3, 4, 3, 2, 1,5,7,9};
        int n = arr.length;
        quickSort(arr, 0, n-1);

        for (int ar : arr) {
            System.out.println("ar = " + ar);
        }
    }
}
