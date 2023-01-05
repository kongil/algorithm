public class Sort_H_Index {
    static class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            for (int h = 10000;  h >= 0; h--) {
                int upCnt = 0;
                int downCnt = 0;
                for (int citation : citations) {
                    if (h <= citation) {
                        upCnt++;
                    }
                    if (h >= citation) {
                        downCnt++;
                    }
                }
                if (upCnt >= h && downCnt <= h) {
                    return h;
                }
            }

            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] citations = {3, 0, 6, 1, 5};

        int answer = solution.solution(citations);
        System.out.println("answer = " + answer);
    }
}
