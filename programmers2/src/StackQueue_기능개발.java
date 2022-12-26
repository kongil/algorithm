import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class StackQueue_기능개발 {
    static class Solution {
        public int afterOneDay(Queue<Integer> q, int[] speeds, int first) {
            int n = q.size();
            for (int i = first; i < n; i++) {
                int front = q.poll();
                System.out.println(front);
                q.add(front + speeds[i]);
            }
            int cnt = 0;
            while (!q.isEmpty() && q.peek() >= 100) {
                q.poll();
                cnt++;
            }
            return cnt;
        }
        public int[] solution(int[] progresses, int[] speeds) {
            int n = progresses.length;
            Queue<Integer> q = new LinkedList<>();
            int[] answer = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                q.add(progresses[i]);
            }
            int aCnt = 0;
            while (!q.isEmpty()) {
                System.out.println(q.size());
                int cnt = afterOneDay(q, speeds, sum);
                System.out.println("cnt : " + cnt);
                answer[aCnt++] = cnt;
                sum += cnt;
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] answer = solution.solution(progresses, speeds);

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
