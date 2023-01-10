import java.util.HashSet;
import java.util.Set;

public class BruteForce_카펫 {
    static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            for (int r = 3; r < 2500; r++) {
                for (int c = 3; c < 2500; c++) {
                    if (brown == 2 * r + 2 * (c - 2) && yellow == (r - 2) * (c - 2)) {
                        answer[0] = r;
                        answer[1] = c;
                        break;
                    }
                }
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int brown = 10;
        int yellow = 2;
        int[] answer = solution.solution(brown, yellow);
        System.out.println("answer = " + answer[0]+ ":" + answer[1]);
    }
}
