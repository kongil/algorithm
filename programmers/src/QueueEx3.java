import java.util.*;

public class QueueEx3 {
    static class Solution {
        static class Truck {
            int startTime;
            int weight;

            public Truck(int startTime, int weight) {
                this.startTime = startTime;
                this.weight = weight;
            }

            public int getStartTime() {
                return startTime;
            }

            public int getWeight() {
                return weight;
            }

            @Override
            public String toString() {
                return "Truck{" +
                        "startTime=" + startTime +
                        ", weight=" + weight +
                        '}';
            }
        }

        public int solution(int bridge_length, int weight, int[] truck_weights) {
            Queue<Truck> q = new LinkedList<>();

            int idx = 0;
            int sum = 0;
            int time = 0;

            sum += truck_weights[idx];
            q.add(new Truck(time, truck_weights[idx]));
            time++;
            idx++;

            while (!q.isEmpty() && time < 100) {
                Truck front = q.peek();
                if (!q.isEmpty()) {
                    if (front.getStartTime() + bridge_length == time) {
                        q.poll();
                        sum -= front.getWeight();
                    }
                }
                if (idx < truck_weights.length && sum + truck_weights[idx] <= weight) {
                    sum += truck_weights[idx];
                    q.add(new Truck(time, truck_weights[idx]));
                    idx++;
                }

                time++;
            }

            return time;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int bridge_length = 2;
        int weight = 10;
        int[] priorities = {7, 4, 5, 6};

        int ans = solution.solution(bridge_length, weight, priorities);

        System.out.println("ans = " + ans);
    }
}
