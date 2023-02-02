public class Dp_등굣길 {
    static class Solution {
        public int solution(int m, int n, int[][] puddles) {
            int answer = 0;
            int[][] dp = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    boolean puddle = false;
                    for (int k = 0; k < puddles.length; k++) {
                        if (i == puddles[k][0]-1 && j == puddles[k][1]-1) {
                            puddle = true;
                        }
                    }
                    if (puddle)
                        dp[i][j] = 0;
                    else {
                        if (i == 0 && j == 0) dp[i][j] = 1;
                        else if (j == 0) dp[i][j] = dp[i-1][j];
                        else if (i == 0) dp[i][j] = dp[i][j-1];
                        else dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;

                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
            return dp[m-1][n-1];
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int m = 7;
//        int n = 4;
//        int[][] pudlles = {{2, 1}, {2,2},{2,3},{4,2},{4,3},{4,4},{6,2},{6,3}};//{{2,1},{2,2}};
        int m = 4;
        int n = 3;
        int[][] pudlles = {{2,2}};//,{4,2},{4,3},{4,4},{6,2},{6,3}};//{{2,1},{2,2}};

        int answer = solution.solution(m, n, pudlles);
        System.out.println("answer = " + answer);
    }
}
