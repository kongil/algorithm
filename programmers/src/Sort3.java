import java.util.*;

class Solution7 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i <= 10000; i++) {
            int cnt = 0;
            for (int j = 0; j < citations.length; j++) {
                if (i <= citations[j]) cnt++;
            }
            if (cnt >= i) {
                answer = i;
            }
        }
        return answer;
    }
}

public class Sort3 {
    public static void main(String[] args) {
        Solution7 solution = new Solution7();

        int[] citations = {6, 5, 3, 3, 3, 1};

        System.out.println(solution.solution(citations));

    }
}
