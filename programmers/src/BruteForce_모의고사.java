import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BruteForce_모의고사 {
    static class Solution {
        static class Grade implements Comparable<Grade>{
            int i;
            int score;

            public Grade(int i, int score) {
                this.i = i;
                this.score = score;
            }

            public int getI() {
                return i;
            }

            public int getScore() {
                return score;
            }

            @Override
            public int compareTo(Grade o) {
                return o.getScore() - this.score;
            }

            @Override
            public String toString() {
                return "Grade{" +
                        "i=" + i +
                        ", score=" + score +
                        '}';
            }
        }

        public int[] solution(int[] answers) {
            int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] arr3 = {3, 1, 2, 4, 5};
            int cnt1 = 0, cnt2 = 0, cnt3 = 0;
            for (int i = 0 ; i < answers.length; i++) {
                if (answers[i] == i % 5 + 1) {
                    cnt1++;
                }
                if (arr2[i%9] == answers[i]) {
                    cnt2++;
                }
                if (arr3[i / 2] == answers[i]) {
                    cnt3++;
                }
            }

            List<Grade> list = new ArrayList<>();
            list.add(new Grade(1, cnt1));
            list.add(new Grade(2, cnt2));
            list.add(new Grade(3, cnt3));

            System.out.println(cnt1 + " " + cnt2 + " " + cnt3);

            Collections.sort(list);
            List<Integer> tmp = new ArrayList<>();

            int ex = 0;
            for (Grade grade : list) {
                if (grade.getScore() >= ex) {
                    System.out.println("grade.toString() = " + grade.toString());
                    ex = grade.getScore();
                    tmp.add(grade.getI());
                }
            }

            int listSize = tmp.size();
            int[] answer = new int[listSize];
            for (int i = 0; i < listSize; i++) {
                answer[i] = tmp.get(i);
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] answers = {1, 3, 2, 4, 2};
        int[] answers = {2, 3, 4, 5, 1};

        int[] solution1 = solution.solution(answers);
        for (int j : solution1) {
            System.out.println("j = " + j);
        }

    }
}
