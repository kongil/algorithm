
class Graph_순위{
    static class Solution {
        public int solution(int n, int[][] results) {
            int answer = 0;
            int INF_MAX = (int)1e9;
            int[][] graph = new int[n+1][n+1];

            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    graph[i][j] = INF_MAX;
                    if (i == j) graph[i][j] = 1;
                }
            }

            for (int[] result : results) {
                int s = result[0];
                int e = result[1];
                graph[s][e] = 1;
            }

            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 0; j <= n; j++) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                boolean isCorrect = true;
                 for (int j = 1; j <= n; j++) {
                     if (graph[i][j] == INF_MAX && graph[j][i] == INF_MAX)
                         isCorrect = false;
                 }
                 if (isCorrect) answer++;
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 5;
        int[][] edge = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};

        System.out.println(solution.solution(n, edge));
    }
}
