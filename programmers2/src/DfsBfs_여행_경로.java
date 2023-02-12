import java.util.*;

public class DfsBfs_여행_경로 {
    static class Solution {
        String[] answer;
        public boolean allVisited(boolean[] visited) {
            for (boolean visit : visited) {
                if (!visit) return false;
            }
            return true;
        }
        public void dfs(String[][] tickets, boolean[] visited, String now, Stack<String> st) {
            if (answer == null && allVisited(visited)) {
                int n = st.size();
                answer = new String[n];
                for (int i = n-1; i >= 0; i--) {
                    answer[i] = st.pop();
                }
                return;
            }

            for (int i = 0; i < tickets.length; i++) {
                String[] ticket = tickets[i];
                String start = ticket[0];
                String end = ticket[1];
                if (!visited[i] && start.equals(now)) {
                    visited[i] = true;
                    st.push(end);
                    dfs(tickets, visited, end, st);
                    if (!st.isEmpty())
                        st.pop();
                    visited[i] = false;
                }
            }
        }
        public void dfsStart(String[][] tickets, boolean[] visited) {
            for (int i = 0; i < tickets.length; i++) {
                String[] ticket = tickets[i];
                String start = ticket[0];
                String end = ticket[1];
                Stack<String> st = new Stack<>();
                st.push("ICN");
                if (start.equals("ICN")) {
                    visited[i] = true;
                    st.push(end);
                    dfs(tickets, visited, end, st);
                    if (!st.isEmpty())
                        st.pop();
                    visited[i] = false;
                }
            }
        }

        public String[] solution(String[][] tickets) {
            boolean[] visited = new boolean[tickets.length];

            Arrays.sort(tickets, (String[] s1, String[] s2)->{
                if (s1[0].equals(s2[0])) {
                    return s1[1].compareTo(s2[1]);
                }
                return s1[0].compareTo(s2[0]);
            });

            dfsStart(tickets, visited);

            return answer;
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
