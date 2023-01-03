import java.util.*;

public class Sort_가장_큰_수 {
    static class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            List<Integer> list = new ArrayList<>();
            for (int number : numbers) {
                list.add(number);
            }
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    String s1 = String.valueOf(o1);
                    String s2 = String.valueOf(o2);

                    return Integer.parseInt(s2 + s1) - Integer.parseInt(s1 + s2);
                }
            });

            for (int i = 0; i < list.size(); i++) {
                answer += list.get(i);
            }

            if (answer.charAt(0)== '0') return "0";

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] numbers = {6, 10, 2};
//        int[] numbers = {3, 30, 34,5, 9};
        int[] numbers = {70, 0, 0, 0};

        String answer = solution.solution(numbers);
        System.out.println("answer = " + answer);
    }
}
