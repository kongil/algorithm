import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

public class StackQueue_주식가격 {
    static class Solution {
        class Node {
            int idx;
            int price;

            public Node(int idx, int price) {
                this.idx = idx;
                this.price = price;
            }
        }
        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];
            Stack<Node> s = new Stack<>();
            for (int i = 0; i < prices.length; i++) {
                while (!s.isEmpty() && s.peek().price > prices[i]) {
                    Node top = s.pop();
                    answer[top.idx] = i - top.idx;
                }
                s.add(new Node(i, prices[i]));
            }
            while (!s.isEmpty()) {
                Node top = s.pop();
                answer[top.idx] = answer.length - top.idx - 1;
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = solution.solution(prices);

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
