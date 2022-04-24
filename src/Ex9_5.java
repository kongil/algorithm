import java.util.*;

class Node5 implements Comparable<Node5>{
    private int idx;
    private int dist;

    public Node5(int idx, int dist) {
        this.idx = idx;
        this.dist = dist;
    }

    public int getIdx() {
        return idx;
    }

    public int getDist() {
        return dist;
    }

    @Override
    public int compareTo(Node5 o) {
        if (o.getDist() > dist) {
            return -1;
        }
        else {
            return 1;
        }
    }
}


public class Ex9_5 {
    static int INF = (int)1e9;
    static ArrayList<ArrayList<Node5>> graph = new ArrayList<>();
    static int[] sd = new int[30001];
    static void dijkstra(int start) {
        PriorityQueue<Node5> pq = new PriorityQueue<>();

        sd[start] = 0;
        pq.add(new Node5(start, 0));

        while (!pq.isEmpty()) {
            Node5 now = pq.poll();
            int idx = now.getIdx();
            int dis = now.getDist();

            if (sd[idx] < dis) continue;

            for (int i = 0; i < graph.get(idx).size(); i++) {
                Node5 next = graph.get(idx).get(i);
                int next_idx = next.getIdx();
                int cost = dis + next.getDist();
                if (cost < sd[next_idx]) {
                    pq.add(next);
                    sd[next_idx] = cost;
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        Arrays.fill(sd, INF);

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph.get(x).add(new Node5(y, z));
        }

        dijkstra(c);

        int cnt = 0, max = 0;
        for (int i = 1; i <= n; i++) {
            if (sd[i] != INF && sd[i] != 0) {
                cnt++;
                max = Math.max(max, sd[i]);
            }
        }

        System.out.println(cnt + " " + max);

    }
}
