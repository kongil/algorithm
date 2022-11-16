import java.util.HashSet;
import java.util.Set;

public class DfsBfs_네트워크v2 {
    static class Solution {
        public void dfs(boolean[] visited, int[][] computers, int now) {
            visited[now] = true;
            for (int i = 0; i < computers[now].length; i++) {
                if (!visited[i] && computers[now][i] == 1) {
                    dfs(visited, computers, i);
                }
            }
        }
        public int solution(int n, int[][] computers) {
            boolean[] visited = new boolean[n];
            int answer = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    dfs(visited, computers, i);
                    answer++;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int[][] numbers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int n = 4;
//        int[][] numbers = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}};
//        int n = 4;
//        int[][] numbers = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        int answer = solution.solution(n, numbers);

        System.out.println(answer);

    }
}
