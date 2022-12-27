import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class StackQueue_프린터 {
    static class Solution {
        class Print {
            int i;
            int priority;

            public Print(int i, int priority) {
                this.i = i;
                this.priority = priority;
            }
        }
        public int solution(int[] priorities, int location) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Queue<Print> q = new LinkedList<>();
            for (int i = 0; i < priorities.length; i++) {
                int priority = priorities[i];

                pq.add(priority);
                q.add(new Print(i, priority));
            }

            int cnt = 0;
            while (!pq.isEmpty()) {
                if (q.peek().priority >= pq.peek()) {
                    cnt++;
                    if (q.peek().i == location) {
                        return cnt;
                    }
                    q.poll();
                    pq.poll();
                }
                else {
                    q.add(q.poll());
                }
            }
            return -1;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int answer = solution.solution(priorities, location);
        System.out.println(answer);
    }
}
