import java.util.*;

public class DP_N으로_표현 {
    static class Solution {
        public int solution(int N, int number) {
            List<Set<Integer>> setList = new ArrayList<>();
            setList.add(new HashSet<>());
            for (int i = 1; i <= 8; i++) {
                String s = "";
                for (int j = 1; j <= i; j++) {
                    s += String.valueOf(N);
                }
                setList.add(new HashSet<>());
                setList.get(i).add(Integer.valueOf(s));
            }
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j < i; j++) {
                    Set<Integer> setA = setList.get(j);
                    Set<Integer> setB = setList.get(i - j);
                    for (int a : setA) {
                        for (int b : setB) {
                            setList.get(i).add(a+b);
                            setList.get(i).add(a-b);
                            setList.get(i).add(a*b);
                            if (b != 0)
                                setList.get(i).add(a/b);
                        }
                    }
                }
            }
            for (int i = 1; i <= 8; i++) {
                for (int j : setList.get(i)) {
                    if (j == number) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] money = {1,1,4,1,4};
        int N = 5;
        int number = 12;

        int answer = solution.solution(N, number);
        System.out.println("answer = " + answer);

    }
}
