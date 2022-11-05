import java.util.*;

public class Ex1 {
    static class Solution {
        public int solution(int[] tasks) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int n = tasks.length;
            for (int task : tasks) {
                pq.add(task);
            }

            int cnt = 0;
            int can = 3;
            int exTask = -1;
            while (!pq.isEmpty()) {
                int task = pq.poll();
                System.out.println("task = " + task + " " + exTask);
                if (exTask != task && can == 2) {
                    cnt = -1;
                    break;
                }
                if (exTask == task && can ==0) {
                    can = 2;
                    cnt++;
                }
                else if (exTask != task) {
                    exTask = task;
                    can = 2;
                    cnt++;
                }
                else {
                   can--;
                }
            }

            answer = cnt;
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] tasks = {1,1,1,1,2,2};
        int answer = solution.solution(tasks);
        System.out.println("answer = " + answer);
    }
}
