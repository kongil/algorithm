import java.util.*;

public class Ex10_3 {
    static int[] parent;
    public static int findParent(int x) {
        if (parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
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
        parent = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            unionParent(x, y);
        }

        for (int i = 1; i <= v; i++) {
            System.out.print(findParent(i) + " ");
        }
        System.out.println();
        for (int i = 1; i <= v; i++) {
            System.out.print(parent[i] + " ");
        }

    }
}
