import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    private int nodeA;
    private int nodeB;
    private int cost;

    public Edge(int nodeA, int nodeB, int cost) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    @Override
    public int compareTo(Edge o) {
        if (o.cost > cost) {
            return -1;
        }
        else {
            return 1;
        }
    }
}

public class Ex10_5 {
    public static int[] parent = new int[100001];
    public static int findParent(int x) {
        if (parent[x] != x) {
            return parent[x] = findParent(parent[x]);
        }
        return x;
    }
    public static void unionParent(int x, int y) {
        int parentX = findParent(x);
        int parentY = findParent(y);

        if (parentX < parentY) {
            parent[parentY] = parentX;
        }
        else {
            parent[parentX] = parentY;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        Edge[] edges = new Edge[e];
        for (int i = 0; i < e; i++) {
            int nodeA = sc.nextInt();
            int nodeB = sc.nextInt();
            int cost = sc.nextInt();
            edges[i] = new Edge(nodeA, nodeB, cost);
        }

        Arrays.sort(edges);

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        int costSum = 0;
        for (Edge edge : edges) {
            int nodeA = edge.getNodeA();
            int nodeB = edge.getNodeB();
            if (findParent(nodeA) != findParent(nodeB)) {
                unionParent(nodeA, nodeB);
                costSum += edge.getCost();
            }
        }

        System.out.println(costSum);
    }
}
