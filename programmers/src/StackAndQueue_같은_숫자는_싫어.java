import java.util.*;

public class StackAndQueue_같은_숫자는_싫어 {

    static class Solution {
        public int[] solution(int[] arr) {
            Deque<Integer> dq = new LinkedList<>();
            for (int i : arr) {
                if (dq.isEmpty() || dq.getLast() != i) {
                    dq.add(i);
                }
            }
            int[] answer = new int[dq.size()];
            int i = 0;
            while (!dq.isEmpty()) {
                answer[i++] = dq.poll();
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,1,3,3,0,1,1};
        int[] answer = solution.solution(arr);
        System.out.println("answer = " + answer.toString());
        for (int i : answer) {
            System.out.println("i = " + i);
        }
    }
}
