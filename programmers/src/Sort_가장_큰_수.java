import java.util.*;

public class Sort_가장_큰_수 {
    static class Solution {
        public class SortMethod implements Comparator<String> {
            @Override
            public int compare(String o1, String o2) {
                int l1 = o1.length();
                int l2 = o2.length();

                char[] chArr1 = o1.toCharArray();
                char[] chArr2 = o2.toCharArray();

                List<Character> chList1 = new ArrayList<>();
                for (Character c : chArr1) {
                    chList1.add(c);
                }

                List<Character> chList2 = new ArrayList<>();
                for (Character c : chArr2) {
                    chList2.add(c);
                }

                for (int i = 0; i < l2; i++) {
                    chList1.add(chList2.get(i));
                }
                for (int i = 0; i < l1; i++) {
                    chList2.add(chList1.get(i));
                }

                StringBuilder sb = new StringBuilder();
                for (Character c : chList1) {
                    sb.append(c);
                }
                int i1 = Integer.valueOf(sb.toString());

                sb.setLength(0);
                for (Character c : chList2) {
                    sb.append(c);
                }
                int i2 = Integer.valueOf(sb.toString());

                return i2 - i1;
            }

        }

        public String solution(int[] numbers) {
            String answer = "";
            List<String> list = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            for (int number : numbers) {
                String s = String.valueOf(number);
                list.add(s);
            }

            System.out.println("sort");
            Collections.sort(list, new SortMethod());

            if (list.get(0).equals("0")) {
                return "0";
            }

            for (String s : list) {
                System.out.println("s = " + s);
                sb.append(s);
            }

            answer = sb.toString();

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] numbers = {3, 30, 34, 5, 9};
//        int[] numbers = {979, 97, 978, 81, 818, 817, 8};
        int[] numbers = {0, 0, 0, 0};
        String answer = solution.solution(numbers);
        System.out.println("answer = " + answer);
    }
}
