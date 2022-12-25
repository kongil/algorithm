import java.util.*;

public class StackQueue_같은_숫자는_싫어 {
    static class Solution {
        public int[] solution(int []arr) {
            Deque<Integer> dq = new LinkedList<>();
            for (int i : arr) {
                if(!dq.isEmpty() && dq.getLast() == i) continue;;

                dq.add(i);
            }

            int[] answer = new int[dq.size()];
            int cnt = 0;
            while (!dq.isEmpty()) {
                answer[cnt++] = dq.poll();
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 1, 3, 3, 0, 1, 1};

        int[] answer = solution.solution(arr);

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
