import java.util.*;

class Solution8 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();

        for (String operation : operations) {
            String[] opArr = operation.split(" ");
            String op = opArr[0];
            int num = Integer.parseInt(opArr[1]);
            if (op.equals("I")) {
                pqMax.add(num);
                pqMin.add(num);
            }
            else {
                if (num == 1) {
                    if (!pqMax.isEmpty()) {
                        int front = pqMax.poll();
                        pqMin.remove(front);
                    }
                }
                else if (num == -1) {
                    if (!pqMin.isEmpty()) {
                        int front = pqMin.poll();
                        pqMax.remove(front);
                    }
                }
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        if (!pqMax.isEmpty()) list.add(pqMax.poll());
        else list.add(0);

        if (!pqMin.isEmpty()) list.add(pqMin.poll());
        else list.add(0);

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

public class PriorityQueue1 {
    public static void main(String[] args) {
        Solution8 solution = new Solution8();

        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        int[] ans = solution.solution(operations);

        for (int an : ans) {
            System.out.println("an = " + an);
        }
    }
}
