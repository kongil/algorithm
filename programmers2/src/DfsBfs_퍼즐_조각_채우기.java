import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DfsBfs_퍼즐_조각_채우기 {
    static class Solution {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        class Point implements Comparable<Point> {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int compareTo(Point o) {
                if (this.x == o.x)
                    return this.y - o.y;
                return this.x - o.x;
            }
        }

        public List<Point> makePuzzle(int[][] table, int r, int c) {
            List<Point> puzzle = new LinkedList<>();
            int n = table.length;
            Queue<Point> q = new LinkedList<>();
            table[r][c] = 0;
            q.add(new Point(r, c));
            puzzle.add(new Point(r, c));

            while (!q.isEmpty()) {
                Point now = q.poll();

                for (int i = 0; i < 4; i++) {
                    Point next = new Point(now.x + dx[i], now.y + dy[i]);

                    if (next.x < 0 || next.x >= n || next.y < 0 || next.y >= n || table[next.x][next.y] == 0) continue;

                    table[next.x][next.y] = 0;
                    puzzle.add(next);
                    q.add(new Point(next.x, next.y));
                }
            }

            return puzzle;
        }

        public List<List<Point>> makePuzzleList(int[][] table) {
            List<List<Point>> puzzleList = new LinkedList<>();
            int n = table.length;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (table[i][j] == 1) {
                        puzzleList.add(makePuzzle(table, i, j));
                    }
                }
            }

            return puzzleList;
        }

        public void reverse(int[][] game_board) {
            int n = game_board.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    game_board[i][j] = game_board[i][j] ^ 1;
                }
            }
        }

        public int findCorrectSpace(List<List<Point>> puzzleList, List<List<Point>> emptyList) {

            int answer = 0;
            int n = emptyList.size();
            int m = puzzleList.size();
            boolean[] empty_visited = new boolean[n];
            boolean[] puzzle_visited = new boolean[m];
            for (int i = 0; i < n; i++) {
                if (empty_visited[i]) continue;
                System.out.println(i);
                List<Point> emptySpace = emptyList.get(i);
                for (int j = 0; j < m; j++) {
                    List<Point> puzzle = puzzleList.get(j);
                    for (int k = 0; k < 4;k++) {
                        if (!empty_visited[i] && !puzzle_visited[j] && correct(emptySpace, puzzle)) {
                            puzzle_visited[j] = true;
                            empty_visited[i] = true;
                            System.out.println("correct");
                            answer += puzzle.size();
                        } else if (!empty_visited[i] && !puzzle_visited[j]) {
                            rotate(puzzle);
                        }
                    }
                }
            }
            return answer;
        }
        public void rotate(List<Point> puzzle) {
            for (int i = 0; i < puzzle.size(); i++) {
                Point p = puzzle.get(i);
                int tmp = p.x;
                p.x = p.y;
                p.y = -tmp;
            }
        }

        public boolean correct(List<Point> emptySpace, List<Point> puzzle) {
            if (emptySpace.size() != puzzle.size()) return false;

            Collections.sort(emptySpace);
            Collections.sort(puzzle);

            int n = emptySpace.size();
            Point e_start = new Point(emptySpace.get(0).x, emptySpace.get(0).y);
            Point p_start = new Point(puzzle.get(0).x, puzzle.get(0).y);

            for (int i = 0; i < n; i++) {
                Point e = emptySpace.get(i);
                e.x -= e_start.x;
                e.y -= e_start.y;
            }
            for (int i = 0; i < n; i++) {
                Point p = puzzle.get(i);
                p.x -= p_start.x;
                p.y -= p_start.y;
            }
            for (int i = 0 ; i < n; i++) {
                Point e = emptySpace.get(i);
                Point p = puzzle.get(i);
            }
            for (int i = 0 ; i < n; i++) {
                Point e = emptySpace.get(i);
                Point p = puzzle.get(i);
                if (e.x != p.x || e.y != p.y) {
                    return false;
                }
            }

            return true;
        }

        public int solution(int[][] game_board, int[][] table) {
            int answer = -1;

            reverse(game_board);
            List<List<Point>> puzzleList = makePuzzleList(table);
            List<List<Point>> emptyList = makePuzzleList(game_board);

            answer = findCorrectSpace(puzzleList, emptyList);

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
