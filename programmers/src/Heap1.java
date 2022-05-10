import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String answer = "";

        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : participant) {
            if (map.containsKey(s)) {
                if (map.get(s) == 1) {
                    map.remove(s);
                }
                else {
                    map.put(s, map.get(s) - 1);
                }
            }
            else {
                answer = s;
                break;
            }
        }

        return answer;
    }
}

public class Heap1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] participant= {"leo", "kiki", "eden"};
        String[] completion= {"leo", "kiki"};

        System.out.println(solution.solution(participant, completion));
    }
}
