import java.util.*;

public class BruteForce_모의고사 {
    static class Solution {
        class Node {
            int idx;
            int cnt;

            public Node(int idx, int cnt) {
                this.idx = idx;
                this.cnt = cnt;
            }
        }
        public int[] solution(int[] answers) {
            int[] answer = {};
            int[] arr1 = {1,2,3,4,5};
            int[] arr2 = {2,1,2,3,2,4,2,5};
            int[] arr3 = {3,3,1,1,2,2,4,4,5,5};
            List<Node> list = new ArrayList<>();
            int cnt1 = 0;
            int cnt2 = 0;
            int cnt3 = 0;
            for (int i = 0; i < answers.length; i++) {
                if (arr1[i%arr1.length] != answers[i]) {
                    cnt1++;
                }
                if (arr2[i%arr2.length] != answers[i]) {
                    cnt2++;
                }
                if (arr3[i%arr3.length] != answers[i]) {
                    cnt3++;
                }
            }
            list.add(new Node(1, cnt1));
            list.add(new Node(2, cnt2));
            list.add(new Node(3, cnt3));
            System.out.println(cnt1 + " " + cnt2 + " " + cnt3);

            Collections.sort(list, new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.cnt - o2.cnt;
                }
            });

            int min = Integer.MAX_VALUE;
            for (Iterator<Node> it = list.iterator(); it.hasNext(); ) {
                Node n = it.next();
                if (n.cnt > min) {
                    it.remove();
                }
                else {
                    min = n.cnt;
                }
            }
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i).idx;
            }
            return answer;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] answers = {1, 3, 2, 4, 2};
        int[] answers = {1, 2, 3, 4, 5};

        int[] answer = solution.solution(answers);
        for (int a : answer) {
            System.out.println("a = " + a);        
        }
    }
}
