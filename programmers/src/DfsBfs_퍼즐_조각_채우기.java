import java.util.*;

public class DfsBfs_퍼즐_조각_채우기 {
    static class Solution {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        public void reverse(int[][] board) {
            int n = board.length;
            for (int i = 0; i < n; i++) {
                 for(int j = 0; j < n; j++) {
                     if (board[i][j] == 0) board[i][j] = 1;
                     else board[i][j] = 0;
                 }
            }
        }
        public int[][] makeEmptySpace(int[][] board, int x, int y) {
            System.out.println("makeEmptySpace : " + x + " " + y);
            int n = board.length;
            int[][] puzzle = new int[n][n];
            Queue<Point> q = new LinkedList<>();
            puzzle[x][y] = 1;
            board[x][y] = 1;
            q.add(new Point(x, y));

            while (!q.isEmpty()) {
                Point now = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nX = now.x + dx[i];
                    int nY = now.y + dy[i];

                    if (nX < 0 || nX >= n || nY < 0 || nY >= n) continue;

                    if (puzzle[nX][nY] == 0 && board[nX][nY] == 0) {
                        puzzle[nX][nY] = 1;
                        board[nX][nY] = 1;
                        q.add(new Point(nX, nY));
                    }
                }
            }
            return puzzle;
        }
        public List<Point> makePuzzle(int[][] board, int x, int y) {
            System.out.println("makePuzze : " + x + " " + y);
            int n = board.length;
            int[][] puzzle = new int[n][n];
            List<Point> list = new LinkedList<>();
            Queue<Point> q = new LinkedList<>();
            puzzle[x][y] = 1;
            board[x][y] = 0;
            q.add(new Point(x, y));

            while (!q.isEmpty()) {
                Point now = q.poll();
                list.add(now);
                for (int i = 0; i < 4; i++) {
                    int nX = now.x + dx[i];
                    int nY = now.y + dy[i];

                    if (nX < 0 || nX >= n || nY < 0 || nY >= n) continue;

                    if (puzzle[nX][nY] == 0 && board[nX][nY] == 1) {
                        puzzle[nX][nY] = 1;
                        board[nX][nY] = 0;
                        q.add(new Point(nX, nY));
                    }
                }
            }
            return list;
        }

        public void makePuzzleList(int[][] map, LinkedList<LinkedList<Point>> list) {
            int n = map.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 && j == 0) {
                        if (map[i][j] == 1) {
                            List<Point> puzzle = makePuzzle(map, i, j);
                            list.add((LinkedList<Point>) puzzle);
                        }
                    }
                    else if (i == 0) {
                        if (map[i][j-1] == 0 && map[i][j] == 1) {
                            List<Point> puzzle = makePuzzle(map, i, j);
                            list.add((LinkedList<Point>) puzzle);
                        }
                    }
                    else if (j == 0) {
                        if (map[i - 1][j] == 0 && map[i][j] == 1) {
                            List<Point> puzzle = makePuzzle(map, i, j);
                            list.add((LinkedList<Point>) puzzle);
                        }
                    }
                    else {
                        if (map[i - 1][j] == 0 && map[i][j-1] == 0 && map[i][j] == 1) {
                            List<Point> puzzle = makePuzzle(map, i, j);
                            list.add((LinkedList<Point>) puzzle);
                        }
                    }
                }
            }
        }
        public int findCorrectPuzzles(LinkedList<int[][]> g, LinkedList<int[][]> t) {
            for (int[][] gmap : g) {
                for (int[][] tmap : t) {

                }
            }
        }
        public boolean isCorrect(int[][] gmap, int[][] tmap) {
            int n = gmap.length;
        }
        public int solution(int[][] game_board, int[][] table) {
            int answer = -1;
            LinkedList<int[][]> g_list = new LinkedList<>();
            LinkedList<int[][]> t_list = new LinkedList<>();

            reverse(game_board);
            makePuzzleList(game_board, g_list);
            makePuzzleList(table, t_list);

            System.out.println("g_list.size() = " + g_list.size());
            System.out.println("t_list.size() = " + t_list.size());

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] game_board = {{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1},
                {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}};
        int[][] table = {{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1},
                {0, 0, 1, 0, 0, 0}, {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};

        int answer = solution.solution(game_board, table);
        System.out.println("answer = " + answer);

    }
}
