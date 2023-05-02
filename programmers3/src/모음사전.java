import java.util.*;

public class 모음사전 {
    static class Solution {
        public char[] alpha = {'A', 'E', 'I', 'O', 'U'};
        int ans = 0;
        public int dfs(String word, int cnt, String answer) {
            cnt++;
            if (answer.equals(word)) {
                ans = cnt;
            }
            if (word.length() >= 5) {
                return cnt;
            }
            int bef = cnt;
            for (int i = 0; i < alpha.length; i++) {
                bef = dfs(word + alpha[i], bef, answer);
            }

            return bef;
        }
        public int solution(String word) {
            int answer = 0;
            dfs("", -1, word);
            answer = ans;
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String word = "EIO";
        int answer = solution.solution(word);
        System.out.println("answer = " + answer);
    }
}
