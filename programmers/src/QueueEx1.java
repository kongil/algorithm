import java.util.*;

class Solution9 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            q.offer((int)Math.ceil((double)(100 - progresses[i])/ speeds[i]));
        }

        int day = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            if (day >= q.peek()) {
                cnt++;
                q.poll();
            }
            else {
                if (cnt != 0) {
                    ans.add(cnt);
                    cnt = 0;
                }
                else {
                    day++;
                }
            }
        }
        if (cnt > 0) ans.add(cnt);
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}

public class QueueEx1 {
    public static void main(String[] args) {
        Solution9 solution = new Solution9();

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        int[] ans = solution.solution(progresses, speeds);

        for (int an : ans) {
            System.out.println("an = " + an);
        }
    }
}
