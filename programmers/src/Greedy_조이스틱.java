import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Greedy_조이스틱 {
    static class Solution {
        boolean[] visited;
        int[] cntArr;
        static class Stick {
            int pos;
            int cnt;

            public Stick(int pos, int cnt) {
                this.pos = pos;
                this.cnt = cnt;
            }

            public int getPos() {
                return pos;
            }

            public int getCnt() {
                return cnt;
            }
        }
        public int[] makeCntArr(String name) {
            int len = name.length();
            char[] nameArr = name.toCharArray();
            int[] cntArr = new int[len];
            for (int i = 0; i < len; i++) {
                cntArr[i] = nameArr[i] - 'A';
                if (cntArr[i] > 13) {
                    cntArr[i] = 26 - cntArr[i];
                }
            }
            return cntArr;
        }
        public void bfs(int now) {
            Queue<Stick> q = new LinkedList<>();
            visited[now] = true;
            q.add(new Stick(now, cntArr[now]));

            while (!q.isEmpty()) {
                Stick s = q.poll();
                now = s.getPos();
                int cnt = s.getCnt();
                System.out.println(now + " : " + cnt);
                int left = now-1;
                if (left < 0) left += visited.length;
                int right = (now + 1) % visited.length;
                if (!visited[left]) {
                    visited[left] = true;
                    q.add(new Stick(left, cnt + 1 + cntArr[left]));
                }
                if (!visited[right]) {
                    visited[right] = true;
                    q.add(new Stick(left, cnt + 1 + cntArr[right]));
                }
            }
        }
        public int solution(String name) {
            int answer = 0;
            cntArr = makeCntArr(name);
            int len = cntArr.length;
            visited = new boolean[len];
            for (int i = 0; i < len; i++) {
                System.out.println(cntArr[i]);
            }
            bfs(0);
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String name = "JEROEN";
        int answer = solution.solution(name);
        System.out.println("answer = " + answer);

    }
}
