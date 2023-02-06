import java.util.HashSet;
import java.util.Set;

public class DfsBfs_네트워크 {
    static class Solution {
        public void dfs(int now, int[][] computers) {
            computers[now][now] = 0;
            for (int i = 0; i < computers[now].length; i++) {
                if (now != i && computers[now][i] == 1) {
                    computers[now][i] = 0;
                    computers[i][now] = 0;
                    dfs(i, computers);
                }
            }
        }
        public int solution(int n, int[][] computers) {
            int answer = 0;
            for (int i = 0; i < n; i++) {
                if (computers[i][i] == 1) {
                    dfs(i, computers);
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
