import java.util.*;

public class Heap_더_맵게 {
    static class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int scov : scoville) {
                pq.add(scov);
            }

            while (pq.size() > 1 && pq.peek() < K) {
                answer++;
                int first = pq.poll();
                int second = pq.poll();

                pq.add(first + 2 * second);
                if (pq.peek() < K && pq.size() == 1) {
                    return -1;
                }
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        int answer = solution.solution(scoville, K);
        System.out.println("answer = " + answer);

    }
}
