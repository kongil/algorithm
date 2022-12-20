import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hash_완주하지_못한_선수 {
    static class Solution {
        public String solution(String[] participant, String[] completion) {
            Map<String, Integer> map = new HashMap<>();
            for (String p : participant) {
               if (map.containsKey(p)) {
                   int cnt = map.get(p);
                   map.replace(p, cnt + 1);
               }
               else {
                   map.put(p, 1);
               }
            }
            for (String c : completion) {
                int cnt = map.get(c);
                if (cnt == 1) {
                    map.remove(c);
                }
                else {
                    map.replace(c, cnt - 1);
                }
            }
            Set<String> set = map.keySet();


            for (String s : set)
                return s;
            return null;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int m = 7;
        int n = 4;
        int[][] pudlles = {{2, 1}, {2,2},{2,3},{4,2},{4,3},{4,4},{6,2},{6,3}};//{{2,1},{2,2}};
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        String answer = solution.solution(participant, completion);
        System.out.println("answer = " + answer);

    }
}
