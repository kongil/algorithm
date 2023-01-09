import java.util.*;

public class BruteForce_소수_찾기 {
    static class Solution {
        boolean[] prime = new boolean[10000001];
        boolean[] visited = new boolean[10000001];
        Set<Integer> set = new HashSet<>();
        public void dfs(char[] chNumbers, String s) {

            for (int i = 0; i < chNumbers.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    set.add(Integer.valueOf(s + chNumbers[i]));
                    dfs(chNumbers, s + chNumbers[i]);
                    visited[i] = false;
                }
            }
        }
        public boolean isPrime(int i) {
            return prime[i];
        }
        public void makePrime(int n) {
            for (int i = 2; i < n; i++) {
                prime[i] = true;
            }
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (isPrime(i)) {
                    int j = 2;
                    while (i * j <= n) {
                        prime[i*j] = false;
                        j++;
                    }
                }
            }
        }
        public int solution(String numbers) {
            int answer = 0;
            makePrime(10000000);
            char[] chNumbers = numbers.toCharArray();
            dfs(chNumbers, "");
            for(int i : set) {
                if (isPrime(i)) {
                    answer++;
                }
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] answers = {1, 3, 2, 4, 2};

        String numbers = "17";
        int answer = solution.solution(numbers);
        System.out.println("answer = " + answer);
    }
}
