import  java.util.*;

public class Ex문자열압축 {
    /**
     * 테스트 1 〉	통과 (0.28ms, 73.6MB)
     * 테스트 2 〉	통과 (1.01ms, 72.5MB)
     * 테스트 3 〉	통과 (0.78ms, 73.1MB)
     * 테스트 4 〉	통과 (0.31ms, 73.7MB)
     * 테스트 5 〉	통과 (0.23ms, 74.3MB)
     * 테스트 6 〉	통과 (0.32ms, 77.2MB)
     * 테스트 7 〉	통과 (1.06ms, 77.3MB)
     * 테스트 8 〉	통과 (1.13ms, 85.7MB)
     * 테스트 9 〉	통과 (1.32ms, 75.4MB)
     * 테스트 10 〉	통과 (4.38ms, 83.2MB)
     * 테스트 11 〉	통과 (0.78ms, 80.9MB)
     * 테스트 12 〉	통과 (0.50ms, 73.6MB)
     * 테스트 13 〉	통과 (0.75ms, 74.1MB)
     * 테스트 14 〉	통과 (1.36ms, 76MB)
     * 테스트 15 〉	통과 (0.85ms, 76.5MB)
     * 테스트 16 〉	통과 (0.40ms, 78.3MB)
     * 테스트 17 〉	통과 (2.19ms, 73.4MB)
     * 테스트 18 〉	통과 (2.43ms, 77MB)
     * 테스트 19 〉	통과 (2.23ms, 77.5MB)
     * 테스트 20 〉	통과 (4.96ms, 81MB)
     * 테스트 21 〉	통과 (4.81ms, 72.8MB)
     * 테스트 22 〉	통과 (5.13ms, 80.5MB)
     * 테스트 23 〉	통과 (5.88ms, 82.1MB)
     * 테스트 24 〉	통과 (4.60ms, 77.4MB)
     * 테스트 25 〉	통과 (6.73ms, 75MB)
     * 테스트 26 〉	통과 (4.70ms, 88.7MB)
     * 테스트 27 〉	통과 (6.46ms, 91.2MB)
     * 테스트 28 〉	통과 (0.23ms, 74.3MB)
     */
    static class Solution {
        public int solution(String s) {
            int len = s.length();
            int minLength = (int)1e9;
            for (int i = 1; i <= len; i++) {
                String ans = compress(s, i);
                minLength = Math.min(minLength, ans.length());
            }
            return minLength;
        }
        public String compress(String s, int n) {
            int len = s.length();
            StringBuilder compressedString = new StringBuilder();
            int compressedCnt = 1;
            String bef = "";
            for (int i = 0; i < Math.ceil((double)len / n); i++) {
                String tmp;
                if (n * (i +1) <= len) {
                    tmp = s.substring(n * i, n * (i + 1));
                }
                else {
                    tmp = s.substring(n * i, len);
                }
                if (bef.equals(tmp)) {
                    compressedCnt++;
                }
                else {
                    if (compressedCnt > 1)
                        compressedString.append(Integer.toString(compressedCnt));
                    compressedString.append(bef);
                    compressedCnt = 1;
                }
                bef = tmp;
            }
            if (compressedCnt > 1)
                compressedString.append(Integer.toString(compressedCnt));
            compressedString.append(bef);

            return compressedString.toString();
        }
    }
    public static void main(String[] args) {

        Solution solution = new Solution();
        String s = "ababcdcdababcdcd";
        System.out.println(solution.solution(s));

    }
}
