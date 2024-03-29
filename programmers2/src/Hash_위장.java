import java.util.*;

public class Hash_위장 {
    static class Solution {
        public int solution(String[][] clothes) {
            Map<String,List<String>> map = new HashMap<>();
            for (String[] cloth : clothes) {
                String name = cloth[0];
                String kind = cloth[1];
                if (!map.containsKey(kind)) {
                    map.put(kind, new ArrayList<>());
                }
                List<String> strList = map.get(kind);
                strList.add(name);
            }
            Collection<List<String>> values = map.values();
            int answer = 1;
            for (List<String> value : values) {
                answer *= (value.size()+1);
            }
            return answer-1;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] clotes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        int answer = solution.solution(clotes);
        System.out.println("answer = " + answer);

    }
}
