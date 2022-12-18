import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch_징검다리 {
    static class Solution {
        public int getLessCnt(int[] rocks, int dis) {
            int cnt = 0;
            int bef = 0;
            for (int i = 0; i < rocks.length; i++) {
                int d = rocks[i] - bef;
                if (d < dis) cnt++;
                else bef = rocks[i];
                System.out.println("d = " + d);
            }
            return cnt;
        }
        public int solution(int distance, int[] rocks, int n) {
            int answer = 0;
            int len = rocks.length;
            Arrays.sort(rocks);
            int left = 1;
            int right = distance;
            while (left <= right) {
                int mid = (left + right) / 2;
                int lessCnt = getLessCnt(rocks, mid);
                System.out.println("lessCnt = " + left + " " + right + " " + mid + " " + lessCnt);
                if (lessCnt <= n) {
                    answer= mid;
                    left = mid + 1;
                }
                else {
                    right = mid - 1;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int distance = 25;
        int[] rocks = {2, 14, 11, 21, 17}; // 2, 11, 14, 17, 21
        int n = 2;

        int answer = solution.solution(distance, rocks, n);
        System.out.println("answer = " + answer);

    }
}
