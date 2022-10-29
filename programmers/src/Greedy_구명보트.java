import java.util.*;

public class Greedy_구명보트 {
    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            boolean[] visited = new boolean[people.length];
            Integer[] peoples = Arrays.stream(people).boxed().toArray(Integer[]::new);
            Arrays.sort(peoples, Collections.reverseOrder());

            int r = people.length - 1;
            for (int l = 0; l < peoples.length; l++) {
                if (visited[l]) break;

                if (peoples[l] + peoples[r] <= limit) {
                    visited[r] = true;
                    r--;
                }
                answer++;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        int answer = solution.solution(people, limit);

        System.out.println("answer = " + answer);

    }
}
