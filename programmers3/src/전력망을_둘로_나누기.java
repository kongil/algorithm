import java.util.*;
import java.util.function.Predicate;

public class 전력망을_둘로_나누기 {
    static class Solution {
        public int solution(int n, int[][] wires) {
            int answer = n;
            for (int i = 0; i < wires.length; i++) {
                boolean[][] graph = new boolean[n+1][n+1];
                makeGraph(graph, wires, i);
                int firstLen = dfs(graph, 1);
                answer = Math.min(Math.abs(n - firstLen - firstLen), answer);
            }

            return answer;
        }

        private int dfs(boolean[][] graph, int start) {
            int ans = 1;
            for (int i = 0; i < graph.length; i++) {
                if (graph[start][i]) {
                    graph[start][i] = false;
                    graph[i][start] = false;
                    ans += dfs(graph, i);
                }
            }
            return ans;
        }

        private void makeGraph(boolean[][] graph, int[][] wires, int exceptIndex) {
            for (int i = 0; i < wires.length; i++) {
                if (i == exceptIndex) continue;
                int[] wire = wires[i];
                int start = wire[0];
                int end = wire[1];
                graph[start][end] = true;
                graph[end][start] = true;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};

        int answer = solution.solution(n, wires);
        System.out.println("answer = " + answer);

    }
}
