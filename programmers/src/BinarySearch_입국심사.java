import java.util.Arrays;

public class BinarySearch_입국심사 {
    static class Solution {
        public long countPerOneMan(long time, )
        public long solution(int n, int[] times) {
            long answer = 0;
            Arrays.sort(times);
            long left = n * times[0];
            long right = n * times[times.length - 1];
            while (left < right) {

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
