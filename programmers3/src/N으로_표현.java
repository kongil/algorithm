import java.util.*;

public class N으로_표현 {
    static class Solution {
        public int dp(int N, int number) {

            List<Set<Integer>> setList = new LinkedList<>();
            for (int i = 0; i <= 8; i++) {
                setList.add(new HashSet<>());
            }

            setList.get(1).add(N);

            Set<Integer> tmpSet = setList.get(1);

            for (int i = 2; i <= 8; i++) {
                for (int j = 1; j < i; j++) {
                    Set<Integer> preSet = setList.get(j);
                    Set<Integer> postSet = setList.get(i-j);
                    for (int pre : preSet) {
                        for (int post : postSet) {
                            setList.get(i).add(pre + post);
                            setList.get(i).add(pre - post);
                            setList.get(i).add(pre * post);
                            if (post > 0)
                                setList.get(i).add(pre / post);
                        }
                    }
                }
                int tmp = 0;
                for (int j = 1; j <= i; j++) {
                    tmp = tmp * 10 + N;
                }
                setList.get(i).add(tmp);
            }

            for (int i = 1; i < setList.size(); i++) {
                Set<Integer> set = setList.get(i);
                for (int in : set) {
                    if (in == number) {
                        return i;
                    }
                }
            }

            return -1;

        }
        public int solution(int N, int number) {
            return dp(N, number);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int N = 5;
        int number = 26;
        int answer = solution.solution(N, number);
        System.out.println("answer = " + answer);
    }
}
