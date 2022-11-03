import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Greedy_단속카메라 {
    static class Solution {
        public int solution(int[][] routes) {
            int answer = 0;

            Arrays.sort(routes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });
            int finalEnd = -30001;
            for (int[] route : routes) {
                int start = route[0];
                int end = route[1];

                if (start <= finalEnd) continue;

                finalEnd = end;
                answer++;

            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
//        int[][] costs = {{0,1,1},{0,2,7},{1,2,5},{1,3,1},{2,3,8}};

        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        int answer = solution.solution(routes);

        System.out.println("answer = " + answer);

    }
}
