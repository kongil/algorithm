import java.util.ArrayList;

public class Ex기둥과보설치 {
    static class Point {
        int x;
        int y;
        boolean[] builded = {false, false}; // 0 : 기둥 1 : 보

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.builded[0] = false;
            this.builded[1] = false;
        }

        public boolean getBuilded(int n) {
            return builded[n];
        }

        public void setBuilded(boolean[] builded) {
            this.builded = builded;
        }
    }

    static class Solution {
        public int[][] solution(int n, int[][] build_frame) {
            Point[][] graph = new Point[n + 2][n + 2];
            for (int i = 0; i < n+2; i++) {
                for (int j = 0; j < n+2; j++) {
                    graph[i][j] = new Point(i, j);
                }
            }
            for (int i = 0; i < build_frame.length; i++) {
                int x = build_frame[i][0];
                int y = build_frame[i][1];
                int a = build_frame[i][2];
                int b = build_frame[i][2];
                if (a == 0) {
                    if (y == 0) {
                        graph[x][y].builded[a] = true;
                    }
                    else if((y > 0 && graph[x][y - 1].builded[0])) {
                        graph[x][y].builded[a] = true;
                    }
                    else if((x > 0 && graph[x-1][y].builded[1])) {
                        graph[x][y].builded[a] = true;
                    }
                }
                else if (a == 1) {
                    if (y == 0) {
                        continue;
                    }
                    // 기둥이 있을 경우
                    else if (graph[x][y - 1].builded[0]) {
                        graph[x][y].builded[a] = true;
                    }
                    else if (x > 0 && x < n) {
                        if (graph[x - 1][y].builded[1] && graph[x + 1][y].builded[1]) {
                            graph[x][y].builded[a] = true;
                        }
                    }
                }
            }

            ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (graph[j][i].builded[0]) {
                        ArrayList<Integer> state = new ArrayList<>();
                        state.add(j);
                        state.add(i);
                        state.add(0);
                        list.add(state);
                    }
                    if (graph[j][i].builded[1]) {
                        ArrayList<Integer> state = new ArrayList<>();
                        state.add(j);
                        state.add(i);
                        state.add(1);
                        list.add(state);
                    }
                }
            }

            int[][] answer = new int[list.size()][3];
            for (int i = 0; i < list.size(); i++) {
                answer[i][0] = list.get(i).get(0);
                answer[i][1] = list.get(i).get(1);
                answer[i][2] = list.get(i).get(2);
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        Solution solution = new Solution();
        int[][] answer = solution.solution(n, build_frame);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
