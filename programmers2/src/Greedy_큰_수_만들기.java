import java.math.BigDecimal;
import java.util.*;

public class Greedy_큰_수_만들기 {
    static class Solution {
        public String makeString(Stack<Integer> s) {
            StringBuilder sb = new StringBuilder();
            Stack<Integer> tmp = new Stack<>();
            boolean firstFlag = true;

            while (!s.isEmpty()) {
                tmp.push(s.pop());
            }

            while (!tmp.isEmpty()) {
                if (firstFlag && tmp.peek() == 0) tmp.pop();
                else if (firstFlag  && tmp.peek() != 0) firstFlag = false;
                else sb.append(String.valueOf(tmp.pop()));
            }

            if (sb.toString().equals("")) return "0";
            return sb.toString();
        }
        public String solution(String number, int k) {
            Stack<Integer> s = new Stack<>();
            char[] chArr = number.toCharArray();
            int[] intArr = new int[chArr.length];
            for (int i = 0; i < chArr.length; i++) {
                intArr[i] = chArr[i] - '0';
            }

            for (int i = 0; i < intArr.length; i++) {
                while (k > 0 && (!s.isEmpty() && s.peek() < intArr[i])) {
                    s.pop();
                    k--;
                }
                s.push(intArr[i]);
            }
            while (k > 0 && !s.isEmpty()) {
                s.pop();
                k--;
            }

            return makeString(s);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String number = "1924";
//        String number = "4177252841";
        String number = "4321";

        int k = 1;
        String answer = solution.solution(number, k);
        System.out.println("answer = " + answer);

    }
}
