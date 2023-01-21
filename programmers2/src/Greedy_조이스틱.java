import java.util.Arrays;
import java.util.function.Predicate;

public class Greedy_조이스틱 {
    static class Solution {
        public int solution(String name) {
            int answer = 0;
            int n = name.length();
            int move = n-1;
            String tmp = "";
            for (int i = 0; i < n; i++)
                tmp += "A";
            char[] nameArr = name.toCharArray();
            char[] tmpArr = tmp.toCharArray();

            for (int i = 0; i < n; i++) {
                answer += Math.min(26-(nameArr[i] - tmpArr[i]), nameArr[i] -tmpArr[i]);
                System.out.println(i + " " + answer + " " + move);

                int lastA = i+1;
                while (lastA < n && nameArr[lastA] == tmpArr[lastA]) {
                    lastA++;
                }

                move = Math.min(move, 2 * i - lastA + n);
                move = Math.min(move, 2 * (n - lastA) + i);
            }

            return answer + move;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String name = "JEROEN";
//        String name = "JAN";
//        String name = "BBBBAAAABA";

        int answer = solution.solution(name);
        System.out.println("answer = " + answer);
    }
}
