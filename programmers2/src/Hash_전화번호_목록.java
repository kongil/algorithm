import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Hash_전화번호_목록 {
    static class Solution {
        public boolean solution(String[] phone_book) {
            Arrays.sort(phone_book, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });

            Set<String> set = new HashSet<>();
            for (String phone : phone_book) {
                boolean hasSub = false;
                for (int i = 1; i <= phone.length(); i++) {
                    String subPhone = phone.substring(0, i);
                    if (set.contains(subPhone)) {
                        return false;
                    }
                }
                set.add(phone);
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] nums = {"119", "97674223", "1195524421"};

        boolean answer = solution.solution(nums);
        System.out.println("answer = " + answer);

    }
}
