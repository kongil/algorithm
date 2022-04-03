import java.util.*;

public class Ex6_6 {

    // 모든 원소의 값이 0보다 크거나 같다고 가정
    static int arr[] = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8, 0};
    // 모든 범위를 포함하는 배열 선언(모든 값은 0으로 초기화)
    static int[] count = new int[10];

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++; // 각 데이터에 해당하는 인덱스의 값 증가
        }

        for (int i = 0; i < count.length; i++) { // 배열에 기록된 정렬 정보 확인
            for (int j = 0; j < count[i]; j++) {
                System.out.print(i + " "); // 띄어쓰기를 기준으로 등장한 횟수만큼 인덱스 출력
            }
        }
        System.out.println();
    }
}
