import java.util.*;

public class Heap_이중우선순위큐 {
    static class Solution {
        public int[] solution(String[] operations) {
            PriorityQueue<Integer> pqMin = new PriorityQueue<>();
            PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());

            for (String operation : operations) {
                String[] s = operation.split(" ");
                String op = s[0];
                int num = Integer.valueOf(s[1]);

                if (op.equals("I")) {
                    pqMax.add(num);
                    pqMin.add(num);
                }
                else {
                    if (num == -1) {
                        if (pqMin.isEmpty()) continue;
                        int front = pqMin.remove();
                        pqMax.remove(front);
                    }
                    else {
                        if (pqMax.isEmpty()) continue;
                        int front = pqMax.remove();
                        pqMin.remove(front);
                    }
                }
            }

            Set<Integer> set = new TreeSet<>(Collections.reverseOrder());
            if (!pqMax.isEmpty()) {
                set.add(pqMax.poll());
            }
            if (!pqMin.isEmpty()) {
                set.add(pqMin.poll());
            }
            int[] answer = {0, 0};
            int cnt = 0;
            for (int x : set) {
                answer[cnt++] = x;
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        int[] answer = solution.solution(operations);
        System.out.println("answer = " + answer[0] + answer[1]);
    }
}
