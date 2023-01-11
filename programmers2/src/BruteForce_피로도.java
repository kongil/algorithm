public class BruteForce_피로도 {
    static class Solution {
        boolean[] visited = new boolean[8];
        int max_depth = 0;
        public void dfs(int k, int[][] dungeons, int depth) {
            max_depth = Math.max(max_depth, depth);
            for (int i = 0; i < dungeons.length; i++) {
                if (!visited[i] && k >= dungeons[i][0]) {
                    visited[i] = true;
                    dfs(k-dungeons[i][1], dungeons, depth+1);
                    visited[i] = false;
                }
            }
        }
        public int solution(int k, int[][] dungeons) {
            dfs(k, dungeons, 0);
            return max_depth;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        int answer = solution.solution(k, dungeons);
        System.out.println("answer = " + answer);
    }
}
