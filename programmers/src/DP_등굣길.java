public class DP_등굣길 {
    static class Solution {
        public boolean isPuddle(int i, int j, int[][] puddles) {
            boolean puddle = false;
            for (int k = 0; k < puddles.length; k++) {
                int x = puddles[k][0]-1;
                int y = puddles[k][1]-1;
                if (x == j && y == i) puddle = true;
            }
            return puddle;
        }
        public int solution(int m, int n, int[][] puddles) {
            int answer = 0;
            int[] dp = new int[m];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    boolean puddle = isPuddle(i, j, puddles);
                    if (puddle) {
                        dp[j] = 0;
                        continue;
                    }
                    if (j == 0) dp[j] = dp[j];
                    else if (i == 0) dp[j] = dp[j-1];
                    else dp[j] = (dp[j-1] + dp[j]) % 1000000007;
                }
                System.out.println();
            }
            return dp[m-1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 7;
        int n = 4;
        int[][] pudlles = {{2, 1}, {2,2},{2,3},{4,2},{4,3},{4,4},{6,2},{6,3}};//{{2,1},{2,2}};

        int answer = solution.solution(m, n, pudlles);
        System.out.println("answer = " + answer);

    }
}
