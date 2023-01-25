import java.util.Arrays;

public class Greedy_단속카메라 {
    static class Solution {
        public int solution(int[][] routes) {
            int answer = 0;
            Arrays.sort(routes, (int[] r1, int[] r2) -> {
                return r1[0] - r2[0];
            });
            int finalEnd = -30001;
            for (int[] route : routes) {

                int s = route[0];
                int e = route[1];
                System.out.print("s = " + s + " ");
                System.out.println("e = " + e);

                if (s <= finalEnd) continue;

                finalEnd = e;
                answer++;
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        int answer = solution.solution(routes);

        System.out.println("answer = " + answer);
    }
}
