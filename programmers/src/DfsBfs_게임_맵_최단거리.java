import java.util.HashSet;
import java.util.Set;

public class DfsBfs_게임_맵_최단거리 {
    static class Solution {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int answer = 0;
        public void dfs(int[][] maps, int x, int y, int cnt) {
            int n = maps.length;
            if (x == n && y == n) {
                answer = cnt;
            }
            for (int i = 0; i < 4; i++) {
                dfs(maps, x + dx[i], y + dy[i], cnt+1);
            }
        }
        public int solution(int[][] maps) {
            int n = maps.length;
            dfs(maps, 0, 0, 0);
            if (answer == 0) answer = -1;
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int n = 3;
//        int[][] numbers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int n = 4;
//        int[][] numbers = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}};
        int n = 4;
        int[][] numbers = [[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	;
        int answer = solution.solution(n, numbers);

        System.out.println(answer);

    }
}
