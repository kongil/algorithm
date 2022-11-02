import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Greedy_섬_연결하기_크루스칼ver {
    static class Solution {
        int[] parent;

        public void unionParent(int x, int y) {
            int parentX = findParent(x);
            int parentY = findParent(y);
            if (parentX < parentY) {
                parent[parentY] = parentX;
            }
//            else if (parentX > parentY){
            else {
                parent[parentX] = parentY;
            }
        }
        public int findParent(int x) {
            if (parent[x] != x) {
                parent[x] = findParent(parent[x]);
            }
            return parent[x];
        }
        public int solution(int n, int[][] costs) {
            parent = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            Arrays.sort(costs, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            });

            int answer = 0;

            for (int[] cost : costs) {
                int nodeA = cost[0];
                int nodeB = cost[1];
                int c = cost[2];
                if (findParent(nodeA) != findParent(nodeB)) {
                    unionParent(nodeA, nodeB);
                    answer += c;
                }
            }

            return answer;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
//        int[][] costs = {{0,1,1},{0,2,7},{1,2,5},{1,3,1},{2,3,8}};
        int[][] costs = {{0,1,1},{3,1,1},{0,2,2},{0,3,2},{0,4,100}};

        int answer = solution.solution(n, costs);

        System.out.println("answer = " + answer);

    }
}
