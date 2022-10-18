import java.util.HashSet;
import java.util.Set;

public class BruteForce_모음_사전 {
    static class Solution {
        char[] alpha = {'A', 'E', 'I', 'O', 'U'};
        int answer = 0;
        boolean find = false;
        public int dfs(String word, String s, int bef) {
            int now = bef;
            if (s.length() > 5) return now-1;
            if (find) return now;
            System.out.println(now + " : " + s);
            if (s.equals(word)) {
                answer = now;
                find = true;
            }
            for (int i = 0; i < 5; i++) {
                now = dfs(word, s + alpha[i], now+1);
            }
            return now;
        }

        public int solution(String word) {
            dfs(word, "", 0);
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String numbers = "I";

        int answer = solution.solution(numbers);
        System.out.println("answer = " + answer);

    }
}
