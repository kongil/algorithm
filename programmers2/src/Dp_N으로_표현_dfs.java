public class Dp_N으로_표현_dfs {
    static class Solution {
        int answer = Integer.MAX_VALUE;
        public int solution(int N, int number) {
            dfs(0, N, number, 0);
            if (answer == Integer.MAX_VALUE) answer = -1;
            return answer;
        }
        public void dfs(int depth, int N, int number, int now) {
            if (depth > 8) return;

            if (number == now) {
                answer = Math.min(answer, depth);
                return;
            }

            int tmp = 0;
            for (int i = 1; i <= 8; i++) {
                tmp = tmp * 10 + N;
                dfs(depth + i, N, number, now + tmp);
                dfs(depth + i, N, number, now - tmp);
                dfs(depth + i, N, number, now * tmp);
                dfs(depth + i, N, number, now / tmp);
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int N = 5;
        int number = 12;
        int answer = solution.solution(N, number);
        System.out.println("answer = " + answer);
    }
}
