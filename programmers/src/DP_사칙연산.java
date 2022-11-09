import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DP_사칙연산 {
    static class Solution {
        public int solution(String arr[]) {
            int answer = -1;
            int n = arr.length;
            int[][] dp = new int[200][2];

            dp[n-1][0] = Integer.valueOf(arr[n-1]);
            dp[n-1][1] = Integer.valueOf(arr[n-1]);
            for (int i = n-1; i >= 0; i--) {
                if (arr[i].equals("-")) {
                    dp[i-1][0] = Math.min(Integer.valueOf(arr[i-1]) - dp[i+1][1], Integer.valueOf(arr[i-1]) - Integer.valueOf(arr[i+1]) + dp[i+3][0]);
                    dp[i-1][1] = Math.max(Integer.valueOf(arr[i-1]) - dp[i+1][0], Integer.valueOf(arr[i-1]) - Integer.valueOf(arr[i+1]) + dp[i+3][1]);
                }
                else if (arr[i].equals("+")) {
                    dp[i-1][0] = dp[i+1][0] + Integer.parseInt(arr[i - 1]);
                    dp[i-1][1] = dp[i+1][1] + Integer.parseInt(arr[i - 1]);
                }
            }

            for (int i = 0; i < n; i++) {
                System.out.println(dp[i][0] + " : " + dp[i][1]);
            }

            answer = dp[0][1];

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] answers = {1, 3, 2, 4, 2};
        String[] arr = {"1", "-", "3", "+", "5", "-", "8"};

        int answer = solution.solution(arr);
        System.out.println("answer = " + answer);

    }
}
