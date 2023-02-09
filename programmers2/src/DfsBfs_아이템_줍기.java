import java.util.LinkedList;
import java.util.Queue;

public class DfsBfs_아이템_줍기 {
    static class Solution {
        public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
            return bfs(rectangle, characterX, characterY, itemX, itemY);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        int[][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
        int answer = solution.solution(rectangle, characterX, characterY, itemX, itemY);

        System.out.println(answer);

    }
}
