import java.util.Stack;

public class BruteForce_최소직사각형 {
    static class Solution {
        public int solution(int[][] sizes) {
            int w = 0;
            int h = 0;
            for (int[] size : sizes) {
                int tmpW = size[0];
                int tmpH = size[1];
                if (tmpW < tmpH) {
                    int tmp = tmpH;
                    tmpH = tmpW;
                    tmpW = tmp;
                }
                w = Math.max(w, tmpW);
                h = Math.max(h, tmpH);
            }
            return w * h;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "()()";
    }
}
