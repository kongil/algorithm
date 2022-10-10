import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class StackAndQueue_올바른_괄호 {

    static class Solution {
        boolean solution(String s) {
            boolean answer = true;
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(c);
                }
                else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
            }

            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()()";
        boolean isRight = solution.solution(s);
        System.out.println("isRight = " + isRight);
    }
}
