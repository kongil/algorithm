import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class StackQueue_다리를_지나는_트럭 {
    static class Solution {
        public int solution(int bridge_length, int weight, int[] truck_weights) {
            int[] bridge = new int[bridge_length];
            Queue<Integer> onTheBridge = new LinkedList<>();
            for (int i = 0; i < bridge_length; i++) {
                onTheBridge.add(0);
            }
            Queue<Integer> q = new LinkedList<>();
            for (int truck_weight : truck_weights) {
                q.add(truck_weight);
            }
            int time = 0;
            int totalWeight = 0;
            while (!q.isEmpty() || totalWeight != 0) {
                time++;
                totalWeight -= onTheBridge.poll();
                System.out.println(time + " " + q.peek() + " " + totalWeight);
                if (!q.isEmpty() && totalWeight + q.peek() <= weight) {
                    totalWeight += q.peek();
                    onTheBridge.add(q.poll());
                }
                else {
                    onTheBridge.add(0);
                }
            }
            return time;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        int answer = solution.solution(bridge_length, weight, truck_weights);

        System.out.println(answer);
    }
}
