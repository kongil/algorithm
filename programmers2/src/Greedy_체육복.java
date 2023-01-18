import java.util.*;
public class Greedy_체육복 {
    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            Arrays.sort(lost);
            Arrays.sort(reserve);
            for (int i = 0; i < lost.length; i++) {
                for (int j = 0; j < reserve.length; j++) {
                    if (lost[i] == reserve[j]) {
                        reserve[j] = -1;
                        lost[i] = -1;
                        answer++;
                        break;
                    }
                }
            }
            for (int i = 0; i < lost.length; i++) {
                for (int j = 0; j < reserve.length; j++) {
                    if (lost[i] == reserve[j]+1 || lost[i] == reserve[j]-1) {
                        reserve[j] = -1;
                        answer++;
                        break;
                    }
                }
            }
            return n - lost.length + answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        int answer = solution.solution(n, lost, reserve);
        System.out.println("answer = " + answer);
    }
}
