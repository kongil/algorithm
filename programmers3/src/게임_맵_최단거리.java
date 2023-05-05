import java.util.*;
public class 게임_맵_최단거리 {
    static class Solution {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        public class Point {
            int x;
            int y;
            int cnt;
            public Point(int x, int y, int cnt) {
                this.x = x;
                this.y = y;
                this.cnt = cnt;
            }
        }

        public int bfs(Point start, int[][] map) {
            Queue<Point> q = new LinkedList<>();
            map[start.y][start.x] = 0;
            q.add(start);

            while (!q.isEmpty()) {
                Point now = q.poll();
                if (now.x == map[0].length-1 && now.y == map.length-1)
                    return now.cnt;

                for (int i = 0; i < 4; i++) {
                    Point next = new Point(now.x + dx[i], now.y + dy[i], now.cnt + 1);
                    if (next.x >= 0 && next.x < map[0].length && next.y >= 0 && next.y < map.length && map[next.y][next.x] == 1) {
                        map[next.y][next.x] = 0;
                        q.add(next);
                    }
                }
            }

            return -1;
        }

        public int solution(int[][] maps) {
            Point start = new Point(0,0, 1);
            return bfs(start, maps);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] maps = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};

        int answer = solution.solution(maps);

        System.out.println("answer = " + answer);

    }
}
