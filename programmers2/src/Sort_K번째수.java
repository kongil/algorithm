import java.util.Arrays;
import java.util.PriorityQueue;

public class Sort_K번째수 {
    static class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            for (int z = 0; z < commands.length; z++) {
                int[] command = commands[z];
                int i = command[0];
                int j = command[1];
                int k = command[2];
                int[] tmp = new int[j-i+1];
                for (int l = i; l <= j; l++) {
                    tmp[l-i] = array[l-1];
                }
                Arrays.sort(tmp);
                answer[z] = tmp[k-1];
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] answer = solution.solution(array, commands);
        for (int i : answer) {
            System.out.println("i = " + i);
        }

    }
}
