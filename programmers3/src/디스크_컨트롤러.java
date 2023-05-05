import java.util.*;

public class 디스크_컨트롤러 {
    static class Solution {
        public class Node implements Comparable<Node> {
            int start;
            int cost;

            public Node(int start, int cost) {
                this.start = start;
                this.cost = cost;
            }

            @Override
            public int compareTo(Node o) {
                return this.cost - o.cost;
            }
        }
        public int solution(int[][] jobs) {
            int answer = 0;
            PriorityQueue<Node> waitPq = new PriorityQueue<>();
            PriorityQueue<Node> jobPq = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.start - o2.start;
                }
            });

            for (int[] job : jobs) {
                jobPq.add(new Node(job[0], job[1]));
            }

            int nextTime = 0;
            for (int i = 0; i <= 1000000; i++) {
                while (!jobPq.isEmpty()) {
                    Node front = jobPq.peek();
                    if (front.start <= i ) {
                        waitPq.add(front);
                        jobPq.poll();
                    }
                    else {
                        break;
                    }
                }

                if (i < nextTime) continue;

                if (!waitPq.isEmpty()) {
                    Node front = waitPq.peek();
                    nextTime = i + front.cost;
                    answer += (nextTime - front.start);
                    waitPq.poll();
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
