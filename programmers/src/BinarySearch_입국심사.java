import java.util.Arrays;

public class BinarySearch_입국심사 {
    static class Solution {
        public long countPerOneMan(long totalTime, int[] times) {
            long cnt = 0;
            for (int time : times) {
                cnt += totalTime / (long)time;
            }
            return cnt;
        }

        public long solution(int n, int[] times) {
            long answer = 0;
            Arrays.sort(times);
            long left = 0;
            long right = (long)n * times[times.length - 1];
            while (left < right) {
                long mid = (left + right) / 2;
                long cnt = countPerOneMan(mid, times);
                if (cnt >= n) {
                    right = mid;
                    answer = mid;
                }
                else {
                    left = mid+1;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 6;
        int[] times = {7, 10};

        long answer = solution.solution(n, times);
        System.out.println("answer = " + answer);

    }
}
