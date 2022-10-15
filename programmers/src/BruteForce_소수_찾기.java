import java.util.*;

public class BruteForce_소수_찾기 {
    static class Solution {
        boolean[] visited = new boolean[10000000];
        char[] numberArr;
        Set<String> set = new HashSet<>();
        boolean[] prime = new boolean[10000000];

        public void makePrime() {
            for (int i = 2; i < 10000000; i++) {
                prime[i] = true;
            }

            for (int i = 2; i <= Math.sqrt(10000000); i++) {
                if (prime[i]) {
                    int j = 2;
                    while (i * j < 10000000) {
                        prime[i * j] = false;
                        j++;
                    }
                }
            }
        }

        public boolean isPrime(String s) {
            return prime[Integer.valueOf(s)];
        }


        public void dfs(String s, int now) {
            int n = numberArr.length;

            String sn = s + numberArr[now];
            sn = String.valueOf(Integer.valueOf(sn));
            System.out.println("sn = " + sn);
            if (isPrime(sn))
                set.add(sn);

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    dfs(sn, i);
                    visited[i] = false;
                }
            }
        }

        public int solution(String numbers) {
            numberArr = numbers.toCharArray();

            makePrime();

            for (int i = 0; i < numberArr.length; i++) {
                visited[i] = true;
                dfs("", i);
                visited[i] = false;
            }
            return set.size();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String numbers = "011";

        int answer = solution.solution(numbers);
        System.out.println("answer = " + answer);

    }
}
