import java.util.*;
class Node {
    int no;
    int distance;

    public Node(int no, int distance) {
        this.no = no;
        this.distance = distance;
    }

    public int getNo() {
        return no;
    }

    public int getDistance() {
        return distance;
    }
}

class Solution10 {
    public int INF_MAX = (int) 1e9;
    ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    boolean[] visited;
    public int solution(int n, int[][] edge) {
        for (int i = 0; i <= n; i++) {
            graph.add(i, new ArrayList<Integer>());
        }
        visited = new boolean[n + 1];
        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return bfs(1);
    }

    public int bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        visited[start] = true;
        q.add(new Node(start, 0));

        int max = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.getDistance() > max) {
                max = now.getDistance();
                cnt = 1;
            }
            else {
                cnt++;

            }
            for (int next : graph.get(now.getNo())) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new Node(next, now.getDistance() + 1));
                }
            }
        }
        return cnt;
    }
}

public class GraphEx1 {
    public static void main(String[] args) {
        Solution10 solution = new Solution10();

        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        System.out.println(solution.solution(n, edge));
    }
}
