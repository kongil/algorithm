import java.util.LinkedList;
import java.util.Queue;

public class DfsBfs_게임_맵_최단거리 {
    static class Solution {
        class Node {
            int x;
            int y;
            int cnt;
            public Node(int x, int y, int cnt) {
                this.x = x;
                this.y = y;
                this.cnt = cnt;
            }
        }
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        public int bfs(int[][] maps) {
            int n = maps.length;
            int m = maps[0].length;

            Queue<Node> q = new LinkedList<>();
            maps[0][0] = 0;
            q.add(new Node(0, 0, 1));
            while (!q.isEmpty()) {
                Node now = q.poll();
                if (now.x == n-1 && now.y == m-1) return now.cnt;

                for (int i = 0; i < 4; i++) {
                    Node next = new Node(now.x+dx[i], now.y+dy[i], now.cnt+1);
                    if (next.x >= 0 && next.x < n && next.y >= 0 && next.y < m && maps[next.x][next.y] == 1) {
                        maps[next.x][next.y] = 0;
                        q.add(next);
                    }
                }
            }
            return -1;
        }
        public int solution(int[][] maps) {
            int answer = bfs(maps);
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int n = 3;
//        int[][] numbers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int n = 4;
//        int[][] numbers = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}};
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        int answer = solution.solution(maps);

        System.out.println(answer);

    }
}
