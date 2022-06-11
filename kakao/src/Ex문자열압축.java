import  java.util.*;

public class Ex문자열압축 {
    static class Solution {
        public int solution(String s) {
            int len = s.length();
            int minLength = (int)1e9;
            for (int i = 1; i <= len; i++) {
                String ans = compress(s, i);
                minLength = Math.min(minLength, ans.length());
                System.out.println("ans = " + ans);
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
