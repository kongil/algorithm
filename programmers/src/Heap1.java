import java.util.*;

public class Heap1 {
    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int i = 0; i < scoville.length; i++) {
                pq.offer(scoville[i]);
            }
            while (pq.size() >= 2) {
                int first = pq.poll();
                int second = pq.poll();
                if (first >= K) {
                    return answer;
                }
                answer++;
                pq.offer(first + second*2);
            }
            if (pq.peek() < K)
                return -1;
            else
                return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        int ans = solution.solution(scoville, K);

        System.out.println("ans = " + ans);
    }
}
