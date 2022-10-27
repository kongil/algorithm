import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Greedy_조이스틱 {
    static class Solution {
        boolean[] visited;
        int[] cntArr;
        int minCnt = 10000000;

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
        public int dfs(int now) {
            int cnt = cntArr[now];
            int len = visited.length;
            int left = now - 1;
            if(left < 0) left += len;
            while ((visited[left] || cntArr[left] == 0) && left != now) {
                left = left - 1;
                if(left < 0) left+= len;
            }
            int right = (now+1) % len;
            while ((visited[right] || cntArr[right] == 0) && right != now) {
                right = (right + 1) % len;
            }

            int leftCnt = minCnt, rightCnt = minCnt;
            if (left != now && !visited[left]) {
                visited[left] = true;
                leftCnt = cnt + dfs(left) + Math.min(Math.abs(now - left), len - Math.abs(now - left));
                visited[left] = false;
            }
            if (right != now && !visited[right]) {
                visited[right] = true;
                rightCnt = cnt + dfs(right) + Math.min(Math.abs(now - right), len - Math.abs(now - right));
                visited[right] = false;
            }

            cnt = Math.min(leftCnt, rightCnt);
            if (cnt == minCnt) cnt = cntArr[now];

            return cnt;
        }
        public int solution(String name) {
            int answer = 0;
            cntArr = makeCntArr(name);
            int len = cntArr.length;
            visited = new boolean[len];
            visited[0] = true;
            answer = dfs(0);
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
