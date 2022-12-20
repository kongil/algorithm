import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hash_폰켓몬 {
    static class Solution {
        public int solution(int[] nums) {
            int answer = 0;
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            if (set.size() > nums.length / 2) {
                answer = nums.length / 2;
            }
            else {
                answer = set.size();
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 1, 2, 3};

        int answer = solution.solution(nums);
        System.out.println("answer = " + answer);

    }
}
