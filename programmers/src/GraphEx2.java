import java.util.*;

class Solution11 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int INF_MAX = (int)1e9;
        int[] indegree = new int[n+1];
        int[][] graph = new int[n+1][n+1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                graph[i][j] = INF_MAX;
                if (i == j) graph[i][j] = 0;
            }
        }

        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0];
            int loser = results[i][1];
            graph[loser][winner] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            boolean canMake = true;
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] >= INF_MAX && graph[j][i] >= INF_MAX) {
                    canMake = false;
                }
            }
            if (canMake) {
                answer++;
            }
        }

        return answer;
    }
}

public class GraphEx2 {
    public static void main(String[] args) {
        Solution11 solution = new Solution11();

        int n = 5;
        int[][] edge = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        System.out.println(solution.solution(n, edge));
    }
}
