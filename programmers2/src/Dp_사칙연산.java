public class Dp_사칙연산 {
    static class Solution {
        public int solution(String arr[]) {
            int answer = -1;
            int n = arr.length;
            int[][] max_dp = new int[n][n];
            int[][] min_dp = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    max_dp[i][j] = Integer.MIN_VALUE/2;
                    min_dp[i][j] = Integer.MAX_VALUE/2;
                }
            }

            for (int i = 0; i < n; i++) {
                if (i%2 == 0) {
                    max_dp[i][i] = Integer.valueOf(arr[i]);
                    min_dp[i][i] = Integer.valueOf(arr[i]);
                }
            }

            for (int cnt = 3; cnt <= n; cnt+=2) {
                for (int left = 0; left < n; left+=2) {
                    int right = left + cnt - 1;
                    if (right >= n) break;
                    for (int oper = left+1; oper < right; oper+=2) {
                        if (arr[oper].equals("+")) {
                            max_dp[left][right] = Math.max(max_dp[left][right], max_dp[left][oper - 1] + max_dp[oper + 1][right]);
                            min_dp[left][right] = Math.min(min_dp[left][right], min_dp[left][oper - 1] + min_dp[oper + 1][right]);
                        }
                        else if (arr[oper].equals("-")) {
                            max_dp[left][right] = Math.max(max_dp[left][right], max_dp[left][oper - 1] - min_dp[oper + 1][right]);
                            min_dp[left][right] = Math.min(min_dp[left][right], min_dp[left][oper - 1] - max_dp[oper + 1][right]);
                        }
                    }
                }
            }

            return max_dp[0][n-1];
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] arr = {"1", "-", "3", "+", "5", "-", "8"};
        int answer = solution.solution(arr);

        System.out.println("answer = " + answer);
    }
}
