import java.util.PriorityQueue;

public class Heap_디스크_컨트롤러 {
    static class Solution {
        class Node implements Comparable<Node> {
            int input_time;
            int spend_time;

            public Node(int input_time, int spend_time) {
                this.input_time = input_time;
                this.spend_time = spend_time;
            }

            @Override
            public int compareTo(Node o) {
                if (this.input_time < o.input_time) {
                    return -1;
                }
                else if (this.input_time == o.input_time) {
                    return this.spend_time - o.spend_time;
                }
                else {
                    return 1;
                }
            }
        }
        public int solution(int[][] jobs) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int answer = 0;
            for (int[] job : jobs) {
                int input_time = job[0];
                int spspend_time = job[1];
                pq.add(new Node(input_time, spspend_time));
            }

            int next_time = pq.peek().input_time;
            int size = pq.size();
            while (!pq.isEmpty()) {
                Node node = pq.poll();
                System.out.println(node.input_time + " : " + node.spend_time);
                answer += (next_time - node.input_time + node.spend_time);
                next_time += node.spend_time;
            }

            return answer / size;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        int answer = solution.solution(jobs);

        System.out.println("answer = " + answer);
    }
}
