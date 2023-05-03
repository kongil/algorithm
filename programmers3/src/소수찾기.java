import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 소수찾기 {
    static class Solution {
        int N = 10000000;
        boolean[] isPrime = new boolean[N];
        Set<Integer> set = new HashSet<>();

        public void palindrome() {

            Arrays.fill(isPrime, true);
            isPrime[0] = false;
            isPrime[1] = false;

            for (int i = 2; i < N; i++) {
                if (isPrime[i] == false) continue;

                for (int j = 2; i * j < N; j++) {
                    isPrime[i*j] = false;
                }
            }
        }

        public void dfs(String s, char[] chArr, boolean[] visited) {
            int iS = 0;
            if (!s.equals("")) {
                iS = Integer.parseInt(s);
            }
            if (isPrime[iS]) {
                set.add(iS);
            }
            for (int i = 0; i < chArr.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(s + chArr[i], chArr, visited);
                    visited[i] = false;
                }
            }
        }

        public int solution(String numbers) {
            palindrome();

            char[] chArr = numbers.toCharArray();

            boolean[] visited = new boolean[chArr.length];

            dfs("", chArr, visited);

            return set.size();
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String number = "000301";
        int answer = solution.solution(number);
        System.out.println("answer = " + answer);
    }
}
