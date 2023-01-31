public class Dp_정수_삼각형 {
    static class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;
            int n = triangle.length;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= i; j++) {
                    if (j == 0) triangle[i][j] += triangle[i-1][j];
                    else if (j == i) triangle[i][j] += triangle[i-1][j-1];
                    else triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
            for (int i = 0; i < n; i++) {
                answer = Math.max(triangle[n - 1][i], answer);
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int answer = solution.solution(triangle);

        System.out.println("answer = " + answer);
    }
}
