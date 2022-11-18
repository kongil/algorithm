import java.util.*;

public class DfsBfs_게임_맵_최단거리v2 {
    static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static class Solution {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        public int bfs(int[][] maps, int x, int y) {
            int n = maps.length;
            int m = maps[0].length;
            Queue<Point> q = new LinkedList<>();
            Point start = new Point(x, y, 1);
            maps[x][y] = 1;
            q.add(start);

            while (!q.isEmpty()) {
                Point now = q.poll();
                if (now.x == n - 1 && now.y == m - 1) {
                    return now.cnt;
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = now.x + dx[i];
                    int nextY = now.y + dy[i];
                    if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || maps[nextX][nextY] == 0) {
                        continue;
                    }
                    maps[nextX][nextY] = 0;
                    q.add(new Point(nextX, nextY, now.cnt + 1));
                }
            }

            return -1;
        }
        public int solution(int[][] maps) {
            int n = maps.length;
            int answer = bfs(maps, 0, 0);
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int n = 3;
//        int[][] numbers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int n = 4;
//        int[][] numbers = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}};
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        int answer = solution.solution(maps);

        System.out.println(answer);

    }
}
