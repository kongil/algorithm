public class BruteForce_전력망을_둘로_나누기 {
    static class Solution {
        boolean[][] graph = new boolean[101][101];
        public int getCount(int now, boolean[] visited, int n) {
            int cnt = 1;
            System.out.println("now = " + now);
            visited[now] = true;
            for (int i = 1; i <= n; i++) {
//                System.out.println(i + " " + visited[i] + " " + graph[now][i]);
                if (!visited[i] && graph[now][i]) {
                    cnt += getCount(i, visited, n);
                }
            }
            return cnt;
        }
        public int solution(int n, int[][] wires) {
            int answer = 1000;
            for (int[] wire : wires) {
                int s = wire[0];
                int e = wire[1];
                graph[s][e] = true;
                graph[e][s] = true;
            }
            for (int[] wire : wires) {
                int s = wire[0];
                int e = wire[1];
                graph[s][e] = false;
                graph[e][s] = false;
                boolean[] visited = new boolean[n+1];
                int sCount = getCount(s, visited, n);
                answer = Math.min(answer, Math.abs(n - 2*sCount));
                graph[s][e] = true;
                graph[e][s] = true;
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int answer = solution.solution(n, wires);
        System.out.println("answer = " + answer);
    }
}
