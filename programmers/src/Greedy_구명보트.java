import java.util.*;

public class Greedy_구명보트 {
    static class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;
            int l = 0, r = people.length - 1;

            Arrays.sort(people);

            while (l <= r) {
                if (people[l] + people[r] <= limit) {
                    l++;
                }
                r--;
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
