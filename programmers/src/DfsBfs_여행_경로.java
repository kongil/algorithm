import java.util.*;

public class DfsBfs_여행_경로 {
    static class Solution {
        boolean find = false;
        List<String> ans = new LinkedList<>();

        public void dfs(String[][] tickets, boolean[] visited, int now, int cnt, List<String> listAnswer) {
            String start = tickets[now][0];
            String end = tickets[now][1];
            System.out.println(now + " : " + start + " : " + visited[now]);
            for (String answer : listAnswer) {
                System.out.println("answer = " + answer);
            }
            int n = tickets.length;
            if (cnt == n-1 && !find) {
                find = true;
                ans.add(end);
                for (String answer : listAnswer) {
                    System.out.println("01answer = " + answer);
                    ans.add(answer);
                }
                return;
            }
            for (int i = 0; i < n; i++) {
                String nextStart = tickets[i][0];
//                String nextEnd = tickets[i][1];
                if (!find && !visited[i] && end.equals(nextStart)) {
                    visited[i] = true;
                    listAnswer.add(nextStart);
                    dfs(tickets, visited, i, cnt + 1, listAnswer);
                }
            }
            if (!find)
                listAnswer.remove(listAnswer.size()-1);
        }
        public String[] solution(String[][] tickets) {
            Arrays.sort(tickets, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    String s1_0 = o1[0];
                    String s1_1 = o1[1];
                    String s2_0 = o2[0];
                    String s2_1 = o2[1];
                    if (s1_0.equals(s2_0)) {
                        return s1_1.compareTo(s2_1);
                    }
                    else {
                        return s1_0.compareTo(s2_0);
                    }
                }
            });

            boolean[] visited = new boolean[tickets.length];

            List<String> dq = new LinkedList<>();
            for (int i = 0; i < tickets.length; i++) {
                visited[i] = true;
                dq.add(tickets[i][0]);
                dfs(tickets, visited, i, 1, dq);
            }

            System.out.println(ans.size());
            Object[] objArr = ans.toArray();
            System.out.println(objArr.length);
            String[] strArr = Arrays.copyOf(objArr, objArr.length, String[].class);

            return strArr;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String[] answer = solution.solution(tickets);

        for (String s : answer) {
            System.out.println("s = " + s);
        }

    }
}
