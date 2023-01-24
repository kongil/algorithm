import java.util.Arrays;
import java.util.Comparator;

public class Greedy_섬_연결하기 {
    static class Solution {
        int[] parent = new int[100];
        public int findParent(int x) {
            if (parent[x] != x) {
                parent[x] = findParent(parent[x]);
            }
            return parent[x];
        }
        public void unionParent(int x, int y) {
            int parentX = findParent(x);
            int parentY = findParent(y);
            if (parentX < parentY) {
                parent[parentY] = parentX;
            }
            else {
                parent[parentX] = parentY;
            }
        }
        public int solution(int n, int[][] costs) {
            int answer = 0;
            Arrays.sort(costs, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            });
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < costs.length; i++) {
                int s = costs[i][0];
                int e = costs[i][1];
                int d = costs[i][2];
                if (findParent(s) != findParent(e)) {
                    answer += d;
                    unionParent(s, e);
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] costs = {{0,1,1},{3,1,1},{0,2,2},{0,3,2},{0,4,100}};

        int answer = solution.solution(n, costs);
        System.out.println("answer = " + answer);

    }
}
