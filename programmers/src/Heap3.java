import java.util.*;

class Solution3 {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String key = cloth[1];
            String value = cloth[0];
            if (map.containsKey(key)) {
                HashSet<String> set = map.get(key);
                set.add(value);
            }
            else {
                HashSet<String> set = new HashSet<>();
                set.add(value);
                map.put(key,set);
            }
        }
        
        Set<String> keys = map.keySet();
        for (String key : keys) {
            int size = map.get(key).size()+1;
            answer *= size;
        }

        answer -= 1;

        return answer;
    }
}

public class Heap3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String[][] s = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        System.out.println(solution.solution(s));
    }
}
