import java.util.*;

public class Ex9_4 {
    private static int INF = (int)1e9;
    private static int[] sd = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    graph[i][j] = 0;
                graph[i][j] = INF;
            }
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph[s][e] = 1;
            graph[e][s] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int x = sc.nextInt();
        int k = sc.nextInt();

        if (graph[1][k] != INF && graph[k][x] != INF) {
            System.out.println(graph[1][k] + graph[k][x]);
        } else {
            System.out.println(-1);
        }

    }
}
