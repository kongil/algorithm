public class DfsBfs_타켓_넘버 {
    static class Solution {
        int answer = 0;
        public void dfs(int[] numbers, int target, int now, int level) {
            int n = numbers.length;
            if (level == n-1) {
                if (now == target)
                    answer++;
                return;
            }
            dfs(numbers, target, now + numbers[level+1], level+1);
            dfs(numbers, target, now - numbers[level+1], level+1);
        }
        public int solution(int[] numbers, int target) {
            dfs(numbers, target, 0, -1);
            return answer;
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
