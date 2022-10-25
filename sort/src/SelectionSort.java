import java.util.*;

// 선택정렬
/*
    해당 순서에 넣을 원소를 선택하는 알고리즘.

    1. 주어진 배열중에 i번째 값을 찾는다.
    2. 그 값을 i번째 위치의 값과 교체하낟.
    3. i+1번째 값에 대하여 1., 2.를 반복

    시간복잡도 : O(n^2)
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {6,3,1,2,3,5,7,9};
        int n = arr.length;
        // 가장 작은 데이터를 선택해 맨 앞의 데이터와 바꾸고 그 다음 작은 데이터를 선택해 2번째 데이터와 바꾸기를 반복한다.
        for (int i = 0; i < n; i++) {
            int minIdx = i;
            // 1.
            for (int j = i+1; j < n; j++) {
                if (arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            // 2.
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
