import java.util.*;

public class Graph_가장_먼_노드 {
    static class Solution {
        class Point {
            int idx;
            int cnt;
            public Point(int idx, int cnt) {
                this.idx = idx;
                this.cnt = cnt;
            }
        }
        int[] sd;
        public void bfs(int n, boolean[][] graph, int now) {
            for (int i = 0; i <= n; i++) {
                sd[i] = -1;
            }
            Queue<Point> q = new LinkedList<>();
            sd[now] = 0;
            q.add(new Point(now, 0));


            while (!q.isEmpty()) {
                Point p = q.poll();

                for (int i = 1; i <= n; i++) {
                    if (sd[i] == -1 && graph[p.idx][i]) {
                        sd[i] = p.cnt+1;
                        q.add(new Point(i, p.cnt+1));
                    }
                }
            }
        }

        public int solution(int n, int[][] edge) {
            sd = new int[n+1];
            for (int i = 1; i <= n; i++) {
                sd[i] = n;
            }
            boolean[][] graph = new boolean[n+1][n+1];
            for (int[] v : edge) {
                int s = v[0];
                int e = v[1];
                graph[s][e] = true;
                graph[e][s] = true;
            }

            bfs(n, graph, 1);

            Arrays.sort(sd);
            int answer = 0;
            int max = 0;
            for (int i : sd) {
                if (i > max) {
                    answer = 1;
                    max = Math.max(max, i);
                }
                else {
                    answer++;
                }
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(solution.solution(n, edge));
    }
}
