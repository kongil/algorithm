import java.util.*;

public class DP_사칙연산 {
    static class Solution {
        public int solution(String arr[]) {
            int MIN = 0, MAX = 1;
            int answer = -1;
            int n = arr.length;
            int[][][] dp = new int[n][n][2];

            for (int i = 0; i < dp.length; i++) {
                 for (int j = 0; j < dp[i].length; j++) {
                     dp[i][j][MIN] = Integer.MAX_VALUE;
                     dp[i][j][MAX] = -Integer.MAX_VALUE;
                 }
            }

            for (int i = 0 ; i < n; i++) {
                if (i % 2 == 0) {
                    dp[i][i][MIN] = Integer.valueOf(arr[i]);
                    dp[i][i][MAX] = Integer.valueOf(arr[i]);
                    if (i+2 < n) {
                        if (arr[i + 1].equals("+")) {
                            dp[i][i + 2][MIN] = Integer.valueOf(arr[i]) + Integer.valueOf(arr[i + 2]);
                            dp[i][i + 2][MAX] = Integer.valueOf(arr[i]) + Integer.valueOf(arr[i + 2]);
                        }
                        else {
                            dp[i][i + 2][MIN] = Integer.valueOf(arr[i]) - Integer.valueOf(arr[i + 2]);
                            dp[i][i + 2][MAX] = Integer.valueOf(arr[i]) - Integer.valueOf(arr[i + 2]);
                        }
                    }
                }
            }

            for (int cnt = 2; cnt < n; cnt+=2) {
                for (int i = 0; i < n; i+=2) {
                    int j = i + cnt;

                    if (j >= n) continue;

                    for (int k = i+1; k < j; k+=2) {
                        if (arr[k].equals("+")) {
                            dp[i][j][MIN] = Math.min(dp[i][k-1][MIN] + dp[k+1][j][MIN], dp[i][j][MIN]);
                            dp[i][j][MAX] = Math.max(dp[i][k-1][MAX] + dp[k+1][j][MAX], dp[i][j][MAX]);
                        }
                        else if (arr[k].equals("-")) {
                            dp[i][j][MIN] = Math.min(dp[i][k-1][MIN] - dp[k+1][j][MAX], dp[i][j][MIN]);
                            dp[i][j][MAX] = Math.max(dp[i][k-1][MAX] - dp[k+1][j][MIN], dp[i][j][MAX]);
                        }
                    }

                }
            }

            return dp[0][n-1][MAX];
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
