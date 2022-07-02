import java.util.*;

public class Heap2 {
    static class Request implements Comparable<Request> {
        int start;
        int time;
        int rstart;
        public Request(int start, int time) {
            this.start = start;
            this.time = time;
        }

        @Override
        public int compareTo(Request o) {
            return this.time - o.time;
        }
    }
    static class Solution {
        public int solution(int[][] jobs) {
            int answer = 0;
            PriorityQueue<Request> pq = new PriorityQueue<>();
            Queue<Integer> done = new LinkedList<>();
            boolean[] visited = new boolean[jobs.length];
            Arrays.fill(visited,false);
            Request doing = null;
            for (int j = 0; j <= 1000000; j++) {
                // 시간이 다 됐으면 종료
                if (doing != null && doing.rstart + doing.time <= j) {
                    done.add(j - doing.start); // 실제 수행시간 넣기
                    doing = null;
                }

                // 대기큐에 넣기
                for (int i = 0; i < jobs.length; i++) {
                    int start = jobs[i][0];
                    int time = jobs[i][1];
                    if (start <= j && !visited[i]) {
                        pq.offer(new Request(start, time));
                        visited[i] = true;
                    }
                }

                // 대기큐 맨 앞에서 한개 뽑기
                if (doing == null && !pq.isEmpty()) {
                    doing = pq.poll();
                    doing.rstart = j;
                }

            }

            int sum = 0;
            int cnt = 0;
            while (!done.isEmpty()) {
                sum += done.poll();
                cnt++;
            }

            if (cnt == 0) return -1;
            return sum / cnt;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] jobs = {{0, 10}, {4, 10}, {15, 2}, {5, 11}};
        int K = 7;

        int ans = solution.solution(jobs);
        System.out.println("ans = " + ans);
    }
}
