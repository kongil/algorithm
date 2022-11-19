import java.util.*;


public class DfsBfs_단어_변환 {
    static class Solution {
        class Count {
            int idx;
            int cnt;

            public Count(int idx, int cnt) {
                this.idx = idx;
                this.cnt = cnt;
            }
        }
        public boolean isDifferentOneWord(String x, String y) {
            int cnt = 0;
            for (int i = 0; i < x.length(); i++) {
                if (x.charAt(i) != y.charAt(i)) {
                    cnt++;
                }
            }
            return cnt == 1;
        }
        public int bfs(String[] words, String begin, String target) {
            Queue<Count> q = new LinkedList<>();
            int n = words.length;
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (isDifferentOneWord(words[i], begin)) {
                    visited[i] = true;
                    q.add(new Count(i, 1));
                }
            }

            while (!q.isEmpty()) {
                Count now = q.poll();
                String nowStr = words[now.idx];
                if (nowStr.equals(target)) {
                    return now.cnt;
                }
                for (int i = 0; i < n; i++) {
                    if (isDifferentOneWord(words[i], nowStr) && !visited[i]) {
                        visited[i] = true;
                        q.add(new Count(i, now.cnt+1));
                    }
                }
            }

            return 0;
        }
        public int solution(String begin, String target, String[] words) {
            return bfs(words, begin, target);
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
