import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DP_정수_삼각형 {
    static class Solution {
        public int solution(int[][] triangle) {
            int answer = 0;

            for (int i = 0; i < triangle.length; i++) {
                for (int j = 0; j < triangle[i].length; j++) {
                    if (i == 0) continue;
                    if (j == 0) triangle[i][j] = triangle[i - 1][j] + triangle[i][j];
                    else if (j == i) triangle[i][j] = triangle[i - 1][j - 1] + triangle[i][j];
                    else triangle[i][j] = Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]) + triangle[i][j];
                }
            }

            int n = triangle.length;
            for (int i = 0; i < n; i++) {
                answer = Math.max(answer, triangle[n - 1][i]);
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
