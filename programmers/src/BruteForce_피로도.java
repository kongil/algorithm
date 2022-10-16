import java.util.HashSet;
import java.util.Set;

public class BruteForce_피로도 {
    static class Solution {
        boolean[] visited = new boolean[9];
        int max = 0;

        public void dfs(int now, int cnt, int[][] dungeons) {
            System.out.println("now = " + now);
            max = Math.max(cnt, max);

            for (int i = 0; i < dungeons.length; i++) {
                if (!visited[i] && now >= dungeons[i][0]) {
                    visited[i] = true;
                    dfs(now - dungeons[i][1], cnt + 1, dungeons);
                    visited[i] = false;
                }
            }
        }

        public int solution(int k, int[][] dungeons) {
            int answer = -1;
            int now = k;
            for (int i = 0; i < dungeons.length; i++) {
                if (!visited[i] && now >= dungeons[i][0]) {
                    visited[i] = true;
                    dfs(now - dungeons[i][1], 1, dungeons);
                    visited[i] = false;
                }
            }
            answer = max;
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};

        int answer = solution.solution(k, dungeons);

        System.out.println("answer = " + answer);

    }
}
