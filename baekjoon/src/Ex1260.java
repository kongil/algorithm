import java.util.*;

public class Ex1260 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int next : graph.get(start)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now + " ");
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
    }
    public static void initialGraph(int n) {
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        visited = new boolean[n+1];
    }

    public static void sortGraph(int n) {
        for (int i = 0; i <= n; i++) {
            Collections.sort(graph.get(i));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();
        initialGraph(n);
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        sortGraph(n);

        Arrays.fill(visited, false);
        dfs(v);
        System.out.println();

        Arrays.fill(visited, false);
        bfs(v);
        System.out.println();
    }

}
