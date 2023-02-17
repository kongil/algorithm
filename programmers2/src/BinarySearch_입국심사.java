import java.util.Arrays;

public class BinarySearch_입국심사 {
    static class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;
            long max = 0;
            for (int time : times) {
                max = Math.max(max, time);
            }
            long l = 0;
            long r = max * (long)n;

            while (l < r) {
                long m = (l + r) / (long)2;
                long t = 0;
                for (int time : times) {
                    t += m / (long) time;
                }
                if (t >= n) r = m;
                else l = m + 1;
            }
            return r;
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
