import java.util.LinkedList;
import java.util.Queue;

public class DfsBfs_아이템_줍기 {
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
        public void makeOuterLine(int[][] rectangle, int[][] map) {
            for (int i = 0; i < rectangle.length; i++) {
                int l_x = 2*rectangle[i][0];
                int l_y = 2*rectangle[i][1];
                int r_x = 2*rectangle[i][2];
                int r_y = 2*rectangle[i][3];
                for (int x = l_x; x <= r_x; x++) {
                    for (int y = l_y; y <= r_y; y++) {
                        if (x == l_x || x == r_x || y == l_y || y == r_y) {
                            map[y][x] = Math.max(map[y][x], 1);
                        }
                        else {
                            map[y][x] = 2;
                        }
                    }
                }
            }
        }
        public int bfs(int[][] map, int characterX, int characterY, int itemX, int itemY) {
            Queue<Point> q = new LinkedList<>();

            map[characterX][characterY] = 2;
            q.add(new Point(characterX, characterY, 0));
            while (!q.isEmpty()) {
                Point now = q.poll();
                System.out.println(now.x + " " + now.y + " " + now.cnt);
                if (now.x == itemX && now.y == itemY) {
                    return now.cnt/2;
                }
                for (int i = 0; i < 4; i++) {
                    Point next = new Point(now.x + dx[i], now.y + dy[i], now.cnt+1);
                    if (map[next.x][next.y] == 1) {
                        map[next.x][next.y] = 2;
                        q.add(next);
                    }
                }
            }
            return -1;
        }

        public int solution (int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            int[][] map = new int[101][101];
            makeOuterLine(rectangle, map);
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    System.out.print(map[20-i][j] + " ");
                }
                System.out.println();
            }

            return bfs(map, 2*characterX, 2*characterY, 2*itemX, 2*itemY);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
//        int[][] rectangle = {{1,1,5,7}};
        int answer = solution.solution(rectangle, characterX, characterY, itemX, itemY);

        System.out.println(answer);

    }
}
