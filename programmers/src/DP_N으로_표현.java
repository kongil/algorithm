public class DP_N으로_표현 {
    static class Solution {
        public int solution(int[] money) {
            int answer = 0;
            int n = money.length;
            int[] dp0 = new int[n];
            int[] dp1 = new int[n];
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    dp0[i] = money[i];
                }
                else if (i == 1) {
                    dp0[i] = dp0[i-1];
                    dp1[i] = money[i];
                }
                else {
                    dp0[i] = Math.max(dp0[i-2] + money[i], dp0[i-1]);
                    dp1[i] = Math.max(dp1[i-2] + money[i], dp1[i-1]);
                }
            }

            return Math.max(Math.max(dp0[n-2], dp0[n-3]), Math.max(dp1[n-1], dp1[n-2]));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] money = {1,1,4,1,4};
        int[] money = {1,2,3,1};

        int answer = solution.solution(money);
        System.out.println("answer = " + answer);

    }
}
