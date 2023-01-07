import java.util.*;

public class BruteForce_모의고사 {
    static class Solution {
        public int[] solution(int[] answers) {
            int[] answer = {};
            int[] arr1 = {1,2,3,4,5};
            int[] arr2 = {2,1,2,3,2,4,2,5};
            int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
            List<Integer> list = new ArrayList<>();
            int cnt1 = 0;
            int cnt2 = 0;
            int cnt3 = 0;
            for (int i = 0; i < answers.length; i++) {
                if (arr1[i%arr1.length] != answers[i]) {
                    cnt1++;
                }
                if (arr2[i%arr2.length] != answers[i]) {
                    cnt2++;
                }
                if (arr3[i%arr3.length] != answers[i]) {
                    cnt3++;
                }
            }
            list.stream().toArray();
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] answers = {1, 3, 2, 4, 2};

        int[] answer = solution.solution(answers);
        for (int a : answer) {
            System.out.println("a = " + a);        
        }
    }
}
