import java.util.*;

class Solution2 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i+1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) {
                    answer = false;
                }
            }
        }

        return answer;
    }
}

public class Heap2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String[] s = {"119", "97674223", "1195524421"};

        System.out.println(solution.solution(s));
    }
}
