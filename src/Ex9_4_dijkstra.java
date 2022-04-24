import java.util.*;

class Node4 implements Comparable<Node4> {
    private int pos;
    private int dis;

    public Node4(int pos, int dis) {
        this.pos = pos;
        this.dis = dis;
    }

    public int getPos() {
        return pos;
    }

    public int getDis() {
        return dis;
    }

    @Override
    public int compareTo(Node4 o) {
        if (o.getDis() > this.dis)
            return 1;
        else
            return -1;
    }
}

public class Ex9_4_dijkstra {
    private static int INF = (int)1e9;
    private static int[] sd = new int[101];
    private static ArrayList<ArrayList<Node4>> graph = new ArrayList<>();
    public static void dijkstra(int s) {
        PriorityQueue<Node4> pq = new PriorityQueue<>();
        pq.add(new Node4(s, 0));
        sd[s] = 0;

        while (!pq.isEmpty()) {
            Node4 now = pq.poll();
            int pos = now.getPos();
            int dis = now.getDis();

            if (sd[pos] < dis) continue;

            for (int i = 0; i < graph.get(pos).size(); i++) {
                Node4 next = graph.get(pos).get(i);
                int next_pos = next.getPos();
                int next_dis = next.getDis();

                if (sd[next_pos] > sd[pos] + next_dis) {
                    sd[next_pos] = Math.min(sd[next_pos], sd[pos] + next_dis);
                    pq.add(next);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node4>());
        }

        for (int i = 0; i < m; i ++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph.get(s).add(new Node4(e, 1));
            graph.get(e).add(new Node4(s, 1));
        }

        for (int i = 1; i <= n; i++) {
            sd[i] = INF;
        }

        int x = sc.nextInt();
        int k = sc.nextInt();
        dijkstra(1);
        int disA = sd[k];
        for (int i = 1; i <= n; i++) {
            sd[i] = INF;
        }
        dijkstra(k);
        int disB = sd[x];

        if (disA + disB < INF)
            System.out.println(disA + disB);
        else
            System.out.println(-1);
    }
}
