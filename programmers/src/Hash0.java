import java.util.HashSet;
import java.util.Set;

public class Hash0 {
    static class Solution {
        public int solution(int[] nums) {
            Set<Integer> set = new HashSet<Integer>();
            for (int num : nums) {
                set.add(num);
            }
            int answer = 0;

            if ((nums.length / 2) > set.size())
                answer = set.size();
            else
                answer = nums.length / 2;
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {3, 1, 2, 3};
        int[] nums = {3, 3, 3, 2, 2, 4};
        int ans = solution.solution(nums);
        System.out.println("ans = " + ans);
    }
}
