import java.util.Arrays;
import java.util.Comparator;
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
                return this.spend_time - o.spend_time;
            }
        }
        public int solution(int[][] jobs) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int answer = 0;
            int next_time = 0;
            for (int i = 0; i <= 1000000; i++) {
                for (int[] job : jobs) {
                    int input_time = job[0];
                    int spend_time = job[1];
                    if (input_time == i) {
                        pq.add(new Node(input_time, spend_time));
                    }
                }
                if (next_time <= i && !pq.isEmpty()) {
                    Node now = pq.poll();
                    next_time = i + now.spend_time;
                    answer += i - now.input_time + now.spend_time;
                }
            }

            return answer / jobs.length;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        int answer = solution.solution(jobs);

        System.out.println("answer = " + answer);
    }
}
