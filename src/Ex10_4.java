import java.util.Scanner;

public class Ex10_4 {
    public static int[] parent = new int[100001];

    public static int findParent(int x) {
        if (parent[x] != x) {
            return parent[x] = findParent(parent[x]);
        }
        return x;
    }

    public static void unionParent(int x, int y) {
        int parentX = parent[x];
        int parentY = parent[y];

        if (parentX < parentY) {
            parent[parentY] = parentX;
        }
        else {
            parent[parentX] = parentY;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean cycle = false;
        int v = sc.nextInt();
        int e = sc.nextInt();

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        while (e-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            if (parent[x] == parent[y]) {
                cycle = true;
            }
            else {
                unionParent(x, y);
            }
        }

        if (cycle)
            System.out.println("사이클이 발생했습니다.");
        else
            System.out.println("사이클이 발생하지 않았습니다.");
    }
}
