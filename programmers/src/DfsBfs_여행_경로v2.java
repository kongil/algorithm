import java.util.*;

public class DfsBfs_여행_경로v2 {
    static class Solution {
        boolean find = false;
        List<String> ans = new LinkedList<>();

        public void dfs(String[][] tickets, boolean[] visited, int cnt, Stack<String> route) {
            if (cnt == tickets.length) {
                if (!find) {
                    find = true;
                    for (String node : route) {
                        ans.add(node);
                    }
                }
            }

            String start = route.peek();

            for (int i = 0; i < tickets.length; i++) {
                if (!visited[i] && tickets[i][0].equals(start)) {
                    visited[i] = true;
                    route.add(tickets[i][1]);
                    dfs(tickets, visited, cnt+1, route);
                    route.pop();
                    visited[i] = false;
                }
            }
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

            Stack<String> route = new Stack<>();
            boolean[] visited = new boolean[tickets.length];

            route.push("ICN");
            dfs(tickets, visited, 0, route);

            Object[] objArr = ans.toArray();
            String[] strArr = Arrays.copyOf(objArr, objArr.length, String[].class);

            return strArr;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        String[] answer = solution.solution(tickets);

        for (String s : answer) {
            System.out.println("s = " + s);
        }

    }
}
