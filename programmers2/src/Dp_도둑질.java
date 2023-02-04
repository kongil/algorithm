public class Dp_도둑질 {
    static class Solution {
        public int solution(int[] money) {
            int n = money.length;
            int[] dp_0 = new int[n];
            int[] dp_1 = new int[n];
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    dp_0[0] = money[0];
                    dp_1[0] = 0;
                }
                else if (i == 1) {
                    dp_0[i] = dp_0[i-1];
                    dp_1[i] = money[i];
                }
                else {
                    dp_0[i] = Math.max(dp_0[i - 1], dp_0[i - 2] + money[i]);
                    dp_1[i] = Math.max(dp_1[i - 1], dp_1[i - 2] + money[i]);
                }
            }
            return Math.max(dp_0[n-2], dp_1[n-1]);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] money = {1,2,3,1};

        int answer = solution.solution(money);
        System.out.println("answer = " + answer);
    }
}
