
import java.util.*;
import java.util.Scanner;

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

public class Ex9_2 {
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static boolean visited[] = new boolean[100001];
    public static int sd[] = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        sd[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int dist = now.getDistance();
            int idx = now.getIndex();

            if (sd[idx] < dist) continue;

            //for (int i = 0; i < graph.get(idx).size(); i++) {
            for (Node next : graph.get(idx)) {
                //Node next = graph.get(idx).get(i);
                int cost = sd[idx] + next.getDistance();

                if (cost < sd[next.getIndex()]) {
                    pq.offer(next);
                    sd[next.getIndex()] = sd[now.getIndex()] + next.getDistance();
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Node>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b,c));
        }

        for (int i = 1; i <= n; i++) {
            sd[i] = Integer.MAX_VALUE;
        }

        dijkstra(start);

        for (int i = 1; i <= n; i++) {
            System.out.println(sd[i]);
        }

    }
}
/**
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
 */
