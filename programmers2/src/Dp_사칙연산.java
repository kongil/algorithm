public class Dp_사칙연산 {
    static class Solution {
        public int solution(String arr[]) {
            int answer = -1;
            int n = arr.length;
            int[][] max_dp = new int[n][n];
            int[][] min_dp = new int[n][n];

            for (int i = 0; i < n; i++) {
                if (i%2 == 0) {
                    max_dp[i][i] = Integer.valueOf(arr[i]);
                    min_dp[i][i] = Integer.valueOf(arr[i]);
                }
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int answer = solution.solution(triangle);

        System.out.println("answer = " + answer);
    }
}
