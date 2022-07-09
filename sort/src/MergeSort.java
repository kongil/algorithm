import java.util.*;

// 병합정렬은 배열의 원소를 1개까지 쪼개서 이후 정렬하면서 합병하는 정렬방식이다.
public class MergeSort {
    static int[] arr = {6,3,1,2,1,5,7,9};
    static int[] sorted;
    public static void merge(int left, int mid, int right) {
        int idx = left;
        int l = left;
        int r = mid+1;
        // 왼쪽, 오른쪽 부분배별에서 작은 순서대로 정렬된 배열에 삽입
        while (l <= mid && r <= right) {
            if (arr[l] < arr[r]) {
                sorted[idx++] = arr[l++];
            }
            else {
                sorted[idx++] = arr[r++];
            }
        }
        // 작은것들을 뽑고 남은 나머지 삽입
        while (l <= mid) {
            sorted[idx++] = arr[l++];
        }
        while (r <= right) {
            sorted[idx++] = arr[r++];
        }

        // 정렬된 배열 넣기
        for (int i = left; i <= right; i++) {
            arr[i] = sorted[i];
        }
    }
    public static void mergeSort(int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;

        mergeSort(left, mid);
        mergeSort(mid+1, right);
        merge(left, mid, right);

    }
    public static void main(String[] args) {
        int n = arr.length;
        sorted = new int[n];
        mergeSort(0, n-1);

        for (int ar : sorted) {
            System.out.println("ar = " + ar);
        }

    }
}
