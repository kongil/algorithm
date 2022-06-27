import java.util.*;

public class QueueEx4 {
    static class Solution {
        class Node {
            int time;
            int price;

            public Node(int time, int price) {
                this.time = time;
                this.price = price;
            }

            public int getTime() {
                return time;
            }

            public int getPrice() {
                return price;
            }
        }

        public int[] solution(int[] prices) {
            Stack<Node> s = new Stack<>();
            int[] answer = new int[prices.length];

            for (int i = 0; i < prices.length; i++) {
                while(!s.isEmpty() && (s.peek().getPrice() > prices[i] || i == prices.length-1)) {
                    answer[s.peek().getTime()] = i - s.peek().getTime();
                    s.pop();
                }

                s.add(new Node(i, prices[i]));
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] prices = {1, 2, 3, 2, 3};

        int[] ans = solution.solution(prices);

        for (int an : ans) {
            System.out.println("an = " + an);        
        }
    }
}
