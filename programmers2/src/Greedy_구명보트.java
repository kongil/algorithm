import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Greedy_구명보트 {
    static class Solution {
        int[] boat = new int[50000];
        public int solution(int[] people, int limit) {
            Arrays.sort(people);
            int l = 0, r = people.length-1;
            while (l < r) {
                if (people[l] + people[r] <= limit) {
                    l++;
                }
                r--;
            }
            return people.length-l;
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
