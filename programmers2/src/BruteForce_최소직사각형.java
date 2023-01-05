public class BruteForce_최소직사각형 {
    static class Solution {
        public int solution(int[][] sizes) {
            int maxMax = 0;
            int maxMin = 0;
            for (int[] size : sizes) {
                int tmpMax, tmpMin;
                if (size[0] < size[1]) {
                    tmpMax = size[1];
                    tmpMin = size[0];
                }
                else {
                    tmpMin = size[1];
                    tmpMax = size[0];
                }
                maxMax = Math.max(maxMax, tmpMax);
                maxMin = Math.max(maxMin, tmpMin);
            }
            return maxMax * maxMin;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

        int answer = solution.solution(sizes);
        System.out.println("answer = " + answer);
    }
}
