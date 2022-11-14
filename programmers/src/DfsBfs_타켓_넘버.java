public class DfsBfs_타켓_넘버 {
    static class Solution {
        int cnt = 0;
        public void dfs(int[] numbers, int idx, int sum, int target) {
            if (idx == numbers.length) {
                if (sum == target) {
                    cnt++;
                }
                return;
            }
            dfs (numbers, idx+1, sum+numbers[idx], target);
            dfs (numbers, idx+1, sum-numbers[idx], target);
        }

        public int solution(int[] numbers, int target) {
            dfs(numbers, 0, 0, target);
            return cnt;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int answer = solution.solution(numbers, target);

        System.out.println(answer);

    }
}
