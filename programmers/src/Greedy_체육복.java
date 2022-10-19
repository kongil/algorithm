import java.util.Arrays;

public class Greedy_체육복 {
    static class Solution {
        public int solution(int n, int[] lost, int[] reserve) {
            int answer = 0;
            boolean[] cloth = new boolean[n+1];
            Arrays.sort(lost);
            Arrays.sort(reserve);
            Arrays.fill(cloth, true);
            cloth[0] = false;
            for (int l : lost) {
                cloth[l] = false;
            }

            for (int i = 0; i < reserve.length; i++) {
                if (!cloth[reserve[i]]) {
                    cloth[reserve[i]] = true;
                    reserve[i] = -1;
                }
            }
            for (int r : reserve) {
                if (r > 1 && !cloth[r - 1])
                    cloth[r-1] = true;
                else if (r < n && !cloth[r + 1])
                    cloth[r+1] = true;
            }

            for (int i = 1; i <= n; i++) {
                answer = cloth[i] ? answer+1 : answer;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 6;
        int[] lost = { 2, 4, 5};
        int[] reserve = {1, 3, 6};

        int answer = solution.solution(n, lost, reserve);
        System.out.println("answer = " + answer);

    }
}
