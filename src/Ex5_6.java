import java.util.Scanner;

public class Ex5_6 {
    public static int INF = 999999999;
    public static int[][] graph = {
            {0, 7, 5},
            {7, 0, INF},
            {5, INF, 0}
    };

    public static void main(String[] args) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + "\t\t\t");
            }
            System.out.println();
        }
    }
}
