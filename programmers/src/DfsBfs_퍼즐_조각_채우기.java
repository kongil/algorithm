import java.util.*;

public class DfsBfs_퍼즐_조각_채우기 {
    static class Solution {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        class Point implements Comparable<Point> {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int compareTo(Point o) {
                if (this.x == o.x) {
                    return this.y - o.y;
                }
                else {
                    return this.x - o.x;
                }
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

        public List<Point> makePuzzle(int[][] board, int x, int y) {
            int n = board.length;
            List<Point> list = new LinkedList<>();
            Queue<Point> q = new LinkedList<>();
            board[x][y] = 0;
            q.add(new Point(x, y));

            while (!q.isEmpty()) {
                Point now = q.poll();
                list.add(now);
                for (int i = 0; i < 4; i++) {
                    int nX = now.x + dx[i];
                    int nY = now.y + dy[i];

                    if (nX < 0 || nX >= n || nY < 0 || nY >= n) continue;

                    if (board[nX][nY] == 1) {
                        board[nX][nY] = 0;
                        q.add(new Point(nX, nY));
                    }
                }
            }
            return list;
        }

        public void makePuzzleList(int[][] map, List<List<Point>> list) {
            int n = map.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == 1) {
                        List<Point> puzzle = makePuzzle(map, i, j);
                        list.add(puzzle);
                    }
                }
            }
            for (int i = 0; i < list.size(); i++) {
                List<Point> pList = list.get(i);
                for (int j = 0; j < pList.size(); j++) {
                    Point p = pList.get(j);
                    System.out.println("p.x + \" \" + p.y = " + p.x + " " + p.y);
                }
            }
        }
        public boolean check(List<Point> emptyBlock, List<Point> puzzle) {
            if (emptyBlock.size() != puzzle.size())
                return false;

            for (int i = 0; i < 4; i++) {
                //가장 좌측상단 Point가 맨 앞으로 오도록
                Collections.sort(puzzle);
                Collections.sort(emptyBlock);

                int firstX = puzzle.get(0).x;
                int firstY = puzzle.get(0).y;

                int firstEmptyX = emptyBlock.get(0).x;
                int firstEmptyY = emptyBlock.get(0).y;
                // (0,0)부터 시작하게 만들기
                for (int j = 0; j < puzzle.size(); j++) {
                    puzzle.get(j).x -= firstX;
                    puzzle.get(j).y -= firstY;
                    emptyBlock.get(j).x -= firstEmptyX;
                    emptyBlock.get(j).y -= firstEmptyY;
                }

                boolean correct = true;
                for (int j = 0; j < emptyBlock.size(); j++) {
                    Point emptyPoint = emptyBlock.get(j);
                    Point puzzlePoint = puzzle.get(j);

                    if (emptyPoint.x != puzzlePoint.x || emptyPoint.y != puzzlePoint.y) {
                        correct = false;
                        break;
                    }
                }

                if (correct) {
                    for (int j = 0; j < emptyBlock.size(); j++) {
                        Point emptyPoint = emptyBlock.get(j);
                        Point puzzlePoint = puzzle.get(j);
                        System.out.println("emptyPoint.x + \" \" + puzzlePoint.x + \" \" + emptyPoint.y + \" \"  puzzlePoint.y = " + emptyPoint.x + " " + puzzlePoint.x + " " + emptyPoint.y + " " + puzzlePoint.y);
                    }
                    System.out.println();
                    return true;
                }
                else {
                    // 90도 회전 (x, y) -> (y, -x)
                    for (int j = 0; j < puzzle.size(); j++) {
                        int tmp = puzzle.get(j).x;
                        puzzle.get(j).x = puzzle.get(j).y;
                        puzzle.get(j).y = -tmp;
                    }
                }
            }
            return false;
        }
        public int solution(int[][] game_board, int[][] table) {
            int answer = 0;
            List<List<Point>> g_list = new LinkedList<>();
            List<List<Point>> t_list = new LinkedList<>();

            reverse(game_board);
            makePuzzleList(game_board, g_list);
            makePuzzleList(table, t_list);

            for (int i = 0; i < g_list.size(); i++) {
                List<Point> emptyBlock = g_list.get(i);
                for (int j = 0; j < emptyBlock.size(); j++) {
                    Point p = emptyBlock.get(j);
                }
            }

            boolean[] g_visited = new boolean[g_list.size()];
            boolean[] t_visited = new boolean[t_list.size()];
            for (int i = 0; i < g_list.size(); i++) {
                List<Point> emptyBlock = g_list.get(i);
                for (int j = 0; j < t_list.size(); j++) {
                    List<Point> puzzle = t_list.get(j);
                    if (!g_visited[i] && !t_visited[j] && check(emptyBlock, puzzle)) {
                        g_visited[i] = true;
                        t_visited[j] = true;
                        answer += puzzle.size();
                        break;
                    }
                }
            }

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
