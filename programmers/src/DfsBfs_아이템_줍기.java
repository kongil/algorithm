import java.util.*;

public class DfsBfs_아이템_줍기 {
    static class Solution {
        class Point {
            int x;
            int y;
            int cnt;

            public Point(int x, int y, int cnt) {
                this.x = x;
                this.y = y;
                this.cnt = cnt;
            }
        }
        int dx[] = {-1, 0, 1, 0};
        int dy[] = { 0, -1, 0, 1};

        public int[][] makeOuterLine(int[][] rectangle) {
            int[][] map = new int[101][101];

            for (int[] rec : rectangle) {
                if (rec.length != 4) return null;
                int l_x = rec[0];
                int l_y = rec[1];
                int r_x = rec[2];
                int r_y = rec[3];
                for(int x = 2*l_x; x <= 2*r_x; x++) {
                    for (int y = 2*l_y; y <= 2*r_y; y++) {
                        if (x == 2*l_x || x == 2*r_x || y == 2*l_y || y == 2*r_y) {
                            map[x][y] = Math.max(map[x][y], 1);
                        }
                        else {
                            map[x][y] = Math.max(map[x][y], 2);
                        }
                    }
                }
            }

            return map;
        }

        public int bfs(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            int[][] map = makeOuterLine(rectangle);
            Queue<Point> q = new LinkedList<>();

            q.add(new Point(2*characterX, 2*characterY, 0));

            while (!q.isEmpty()) {
                Point now = q.poll();
                int x = now.x;
                int y = now.y;
                int cnt = now.cnt;
                if (x == 2*itemX && y == 2*itemY) {
                    return cnt/2;
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx < 1 || nx > 100 || ny < 1 || ny > 100 || map[nx][ny] != 1) continue;

                    map[nx][ny] = 2;
                    q.add(new Point(nx, ny, cnt + 1));
                }
            }

            return -1;

        }
        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            return bfs(rectangle, characterX, characterY, itemX, itemY);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int answer = solution.solution(rectangle, characterX, characterY, itemX, itemY);

        System.out.println(answer);

    }
}
