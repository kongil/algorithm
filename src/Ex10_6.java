import java.util.*;

public class Ex10_6 {
    public static int[] indegree;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int v;
    public static int e;

    public static void topologySort() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= v; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                indegree[i]--;
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();

            for (Integer next : graph.get(now)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
            System.out.print(now + " ");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        e = sc.nextInt();

        indegree = new int[v + 1];
        for (int i = 0; i < v+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph.get(s).add(e);
            indegree[e]++;
        }

        topologySort();

    }
}
