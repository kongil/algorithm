import java.util.Arrays;
import java.util.PriorityQueue;

public class Greedy_섬_연결하기 {
    static class Solution {
        int[][] graph;
        boolean[] visited;

        class Node implements Comparable<Node> {
            private int index;
            private int distance;

            public Node(int index, int distance) {
                this.distance = distance;
                this.index = index;
            }

            public int getIndex() {
                return index;
            }

            public void setIndex(int index) {
                this.index = index;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            @Override
            public int compareTo(Node other) {
                if (this.distance < other.getDistance())
                    return -1;
                else
                    return 1;
            }
        }

        public int bfs(int start) {
            int sum = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(start, 0));

            while (!pq.isEmpty()) {
                Node now = pq.poll();
                int idx = now.getIndex();
                int dist = now.getDistance();
                if (visited[idx]) continue;
                visited[idx] = true;

                sum += dist;
                System.out.println(idx + " " +dist);
                for (int i = 0; i < graph[idx].length; i++) {
                    if (!visited[i] && graph[idx][i] != 0) {
                        pq.add(new Node(i, graph[idx][i]));
                    }
                }
            }
            return sum;
        }
        public int solution(int n, int[][] costs) {
            visited = new boolean[n];
            graph = new int[n][n];
            for (int i = 0; i < costs.length; i++) {
                int s = costs[i][0];
                int e = costs[i][1];
                int c = costs[i][2];
                graph[s][e] = c;
                graph[e][s] = c;
            }
            int answer = bfs(0);

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
//        int[][] costs = {{0,1,1},{0,2,7},{1,2,5},{1,3,1},{2,3,8}};
        int[][] costs = {{0,1,1},{3,1,1},{0,2,2},{0,3,2},{0,4,100}};

        int answer = solution.solution(n, costs);

        System.out.println("answer = " + answer);

    }
}
