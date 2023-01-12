public class BruteForce_모음사전 {
    static class Solution {
        char[] alpha = {'A', 'E', 'I', 'O', 'U'};
        boolean find = false;
        public int dfs(String word, String s, int now) {
            System.out.println(s + " " + now);
            if (s.equals(word)) {
                find = true;
                return now;
            }
            if (find) return now-1;
            if (s.length() >= 5) return now;

            for (int i = 0; i < alpha.length; i++) {
                now = dfs(word, s + alpha[i], now+1);
            }
            return now;
        }
        public int solution(String word) {
            int answer = dfs(word, "", 0);
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String word = "I";
        String word = "AAAE";
        int answer = solution.solution(word);
        System.out.println("answer = " + answer);
    }
}
