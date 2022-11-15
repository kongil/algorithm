import java.util.*;

public class DfsBfs_네트워크 {
    static class Solution {
        int[] parent = new int[201];

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

        public int solution(int n, int[][] computers) {
            for (int i = 0 ; i < n; i++) {
                parent[i] = i;
            }
            for (int i = 0; i < computers.length; i++) {
                for (int j = 0; j < n; j++) {
                    if (computers[i][j] == 1) {
                        unionParent(i, j);
                    }
                }
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(findParent(i));
            }
            return set.size();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int n = 3;
//        int[][] numbers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
//        int n = 4;
//        int[][] numbers = {{1, 1, 0, 1}, {1, 1, 0, 0}, {0, 0, 1, 1}, {1, 0, 1, 1}};
        int n = 4;
        int[][] numbers = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        int answer = solution.solution(n, numbers);

        System.out.println(answer);

    }
}
