import java.util.ArrayList;
import java.util.List;

public class BruteForce_카펫 {
    static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            for (int w = yellow+2; w >= 1; w -= 1) {
                if ((brown + yellow) % w == 0) {
                    int h = (brown + yellow) / w;

                    if ((2 * (w + h -2)) == brown && (w - 2) * (h - 2) == yellow) {
                        answer[0] = w;
                        answer[1] = h;
                        break;
                    }

                    if (h > w) break;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] solution1 = solution.solution(8, 1);
        for (int i : solution1) {
            System.out.println("i = " + i);
        }
    }
}
