import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BruteForce_전력망을_둘로_나누기 {
    static class Solution {
        boolean[] visited = new boolean[101];
        boolean[][] graph;
        public void initVisited() {
            for (int i = 0; i < visited.length; i++) {
                visited[i] = false;
            }
        }
        public int getCount(int now) {
            visited[now] = true;
            System.out.println("now : " + now);
            int count = 1;
            for (int i = 1; i < graph[now].length; i++) {
                if (!visited[i] && graph[now][i]) {
                    count += getCount(i);
                }
            }
            return count;
        }
        public int solution(int n, int[][] wires) {
            graph = new boolean[n+1][n+1];
            for (int[] wire : wires) {
                int s = wire[0];
                int e = wire[1];
                graph[s][e] = true;
                graph[e][s] = true;
            }


            int answer = 100;
            for (int i = 0; i < wires.length; i++) {
                int s = wires[i][0];
                int e = wires[i][1];
                System.out.println(s + " " + e);
                graph[s][e] = false;
                graph[e][s] = false;
                initVisited();
                int sCount = getCount(s);
                initVisited();
                int eCount = getCount(e);
                System.out.println(sCount + " : " + eCount);
                answer = Math.min(answer, Math.abs(sCount - eCount));
                graph[s][e] = true;
                graph[e][s] = true;
            }

            return answer;
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
