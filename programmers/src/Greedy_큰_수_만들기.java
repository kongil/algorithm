import java.util.Arrays;
import java.util.Stack;

public class Greedy_큰_수_만들기 {
    static class Solution {
        public String solution(String number, int k) {
            Stack<Integer> stack = new Stack<>();
            char[] chArr = number.toCharArray();
            int[] intArr = new int[chArr.length];
            for (int i = 0; i < chArr.length; i++) {
                intArr[i] = chArr[i] - '0';
            }
            for (int i = 0; i < intArr.length; i++) {
                while (k > 0 && !stack.isEmpty() && stack.peek() < intArr[i]) {
                    k--;
                    stack.pop();
                }

                stack.push(intArr[i]);
            }
            while (k > 0 && !stack.isEmpty()) {
                k--;
                stack.pop();
            }

            StringBuilder sb = new StringBuilder();
            int n = stack.size();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            sb.reverse();
            String answer = sb.toString();
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String number = "1924";
        int k = 2;

        String answer = solution.solution(number, k);

        System.out.println("answer = " + answer);

    }
}
