import java.util.LinkedList;
import java.util.Queue;


public class DfsBfs_단어_변환 {
    static class Solution {
        class Pair {
            String s;
            int cnt;
            public Pair(String s, int cnt) {
                this.s = s;
                this.cnt = cnt;
            }
        }
        public boolean isDifferOne(String a, String b) {
            if (a.length() != b.length()) {
                return false;
            }
            int cnt = 0;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) != b.charAt(i)) {
                    cnt++;
                }
            }
            if (cnt == 1) return true;
            return false;
        }
        public int bfs(String begin, String target, String[] words) {
            Queue<Pair> q = new LinkedList<>();
            int n = words.length;
            boolean[] visited = new boolean[n];

            q.add(new Pair(begin, 0));
            while (!q.isEmpty()) {
                Pair now = q.poll();
                String now_s = now.s;
                if (now_s.equals(target)) {
                    return now.cnt;
                }
                for (int i = 0; i < n; i++) {
                    if (!visited[i] && isDifferOne(now_s, words[i])) {
                        visited[i] = true;
                        q.add(new Pair(words[i], now.cnt+1));
                    }
                }
            }

            return 0;
        }
        public int solution(String begin, String target, String[] words) {
            int answer = 0;
            answer= bfs(begin, target, words);
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        int answer = solution.solution(begin, target, words);

        System.out.println(answer);

    }
}
