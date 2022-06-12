import java.util.*;
import java.util.stream.*;

public class Ex기둥과보설치 {
    /**
     * 테스트 1 〉	통과 (14.11ms, 79MB)
     * 테스트 2 〉	통과 (16.83ms, 75.8MB)
     * 테스트 3 〉	통과 (18.43ms, 75.2MB)
     * 테스트 4 〉	통과 (16.28ms, 81.3MB)
     * 테스트 5 〉	통과 (17.72ms, 88.3MB)
     * 테스트 6 〉	통과 (23.50ms, 78.8MB)
     * 테스트 7 〉	통과 (14.26ms, 81.2MB)
     * 테스트 8 〉	통과 (14.98ms, 81.5MB)
     * 테스트 9 〉	통과 (19.40ms, 80.8MB)
     * 테스트 10 〉	통과 (265.90ms, 85.4MB)
     * 테스트 11 〉	통과 (1091.24ms, 81.7MB)
     * 테스트 12 〉	통과 (237.65ms, 84.1MB)
     * 테스트 13 〉	통과 (1016.80ms, 85MB)
     * 테스트 14 〉	통과 (260.22ms, 91MB)
     * 테스트 15 〉	통과 (1531.79ms, 100MB)
     * 테스트 16 〉	통과 (271.10ms, 101MB)
     * 테스트 17 〉	통과 (1493.30ms, 106MB)
     * 테스트 18 〉	통과 (892.99ms, 96.8MB)
     * 테스트 19 〉	통과 (970.79ms, 104MB)
     * 테스트 20 〉	통과 (922.77ms, 83MB)
     * 테스트 21 〉	통과 (656.35ms, 88.7MB)
     * 테스트 22 〉	통과 (522.21ms, 97MB)
     * 테스트 23 〉	통과 (661.24ms, 99.8MB)
     */
    static class Solution {
        public boolean check(ArrayList<ArrayList<Integer>> answer) {
            int x, y, a;
            boolean ret = true;
            for (int i = 0; i < answer.size(); i++) {
                boolean can = false;
                x = answer.get(i).get(0);
                y = answer.get(i).get(1);
                a = answer.get(i).get(2);
                if (a == 0) { // 기둥
                    if (y == 0) {
                        can = true;
                    }
                    else {
                        for (int j = 0; j < answer.size(); j++) {
                            if (answer.get(j).get(0) == x && answer.get(j).get(1) == y-1 && answer.get(j).get(2) == 0) {
                                can = true;
                            }
                            if (answer.get(j).get(0) == x && answer.get(j).get(1) == y && answer.get(j).get(2) == 1) {
                                can = true;
                            }
                            if (answer.get(j).get(0) == x-1 && answer.get(j).get(1) == y && answer.get(j).get(2) == 1) {
                                can = true;
                            }
                        }
                    }
                }
                else if (a == 1) { // 보
                    boolean left = false;
                    boolean right = false;
                    for (int j = 0; j < answer.size(); j++) {
                        if (answer.get(j).get(0) == x-1 && answer.get(j).get(1) == y && answer.get(j).get(2) == 1) {
                            left = true;
                        }
                        if (answer.get(j).get(0) == x+1 && answer.get(j).get(1) == y && answer.get(j).get(2) == 1) {
                            right = true;
                        }
                        if (answer.get(j).get(0) == x && answer.get(j).get(1) == y-1 && answer.get(j).get(2) == 0) {
                            can = true;
                        }
                        if (answer.get(j).get(0) == x+1 && answer.get(j).get(1) == y-1 && answer.get(j).get(2) == 0) {
                            can = true;
                        }
                    }
                    if (!can) can = left && right;
                }
                ret = ret && can;
            }
            return ret;
        }
        public int[][] solution(int n, int[][] build_frame) {
            ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

            for (int i = 0; i < build_frame.length; i++) {
                int x = build_frame[i][0];
                int y = build_frame[i][1];
                int a = build_frame[i][2];
                int b = build_frame[i][3];
                System.out.println(x + " " + y + " " + a + " " + b);
                if (b == 0) { // 삭제
                    int idx = -1;
                    for (int j = 0; j < answer.size(); j++) {
                        if (x == answer.get(j).get(0) && y == answer.get(j).get(1) && a == answer.get(j).get(2)) {
                            idx = j;
                            break;
                        }
                    }
                    if (idx != -1) {
                        ArrayList<Integer> erased = answer.get(idx);
                        answer.remove(idx);
                        if (!check(answer)) {
                            answer.add(erased);
                        }
                    }
                }
                else if (b == 1) { // 설치
                    int[] tmp = {x, y, a};
                    ArrayList<Integer> intList = (ArrayList<Integer>) Arrays.stream(tmp).boxed().collect(Collectors.toList());

                    answer.add(intList);
                    if (!check(answer)) {
                        answer.remove(intList);
                    }
                }
            }

            int[][] arr = new int[answer.size()][3];
            for (int i = 0; i < answer.size(); i++) {
                arr[i][0] = answer.get(i).get(0);
                arr[i][1] = answer.get(i).get(1);
                arr[i][2] = answer.get(i).get(2);
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[0] != o2[0]) {
                        return o1[0] - o2[0];
                    }
                    else if (o1[1] != o2[1]) {
                        return o1[1] - o2[1];
                    }
                    else {
                        return o1[2] - o2[2];
                    }
                }
            });

            return arr;
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] build_frame = {{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};
        int[][] build_frame2 = {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};
        Solution solution = new Solution();
        int[][] answer = solution.solution(n, build_frame2);
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }
}
