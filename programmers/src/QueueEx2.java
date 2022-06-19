import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueEx2 {
    static class Node implements Comparable<Node>{
        int no;
        int priority;

        public Node(int no, int priority) {
            this.no = no;
            this.priority = priority;
        }

        public int getNo() {
            return no;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public int compareTo(Node o) {
            return o.priority - priority;
        }
    }
    static class Solution {
        public int solution(int[] priorities, int location) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            Queue<Node> q = new LinkedList<>();
            int[] prints = new int[priorities.length];

            for (int i = 0; i < priorities.length; i++) {
                pq.add(new Node(i, priorities[i]));
                q.add(new Node(i, priorities[i]));
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                Node tmp = pq.peek();

                Node now = q.poll();

                if (now.getPriority() == tmp.getPriority()) {
                    pq.poll();
                    cnt++;
                    prints[now.getNo()] = cnt;
                }
                else {
                    q.add(now);
                }
            }

            return prints[location];
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        int ans = solution.solution(priorities, location);

        System.out.println("ans = " + ans);
    }
}
