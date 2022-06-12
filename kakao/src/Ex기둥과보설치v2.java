import java.util.*;

/**
 * 테스트 1 〉	통과 (0.82ms, 78.5MB)
 * 테스트 2 〉	통과 (1.05ms, 74.8MB)
 * 테스트 3 〉	통과 (1.02ms, 74.7MB)
 * 테스트 4 〉	통과 (2.02ms, 75.3MB)
 * 테스트 5 〉	통과 (1.92ms, 74.5MB)
 * 테스트 6 〉	통과 (3.30ms, 77MB)
 * 테스트 7 〉	통과 (0.65ms, 72.3MB)
 * 테스트 8 〉	통과 (0.88ms, 74.5MB)
 * 테스트 9 〉	통과 (1.70ms, 79.2MB)
 * 테스트 10 〉	통과 (45.23ms, 78.4MB)
 * 테스트 11 〉	통과 (280.64ms, 83.5MB)
 * 테스트 12 〉	통과 (38.77ms, 87.3MB)
 * 테스트 13 〉	통과 (260.07ms, 103MB)
 * 테스트 14 〉	통과 (54.68ms, 74.3MB)
 * 테스트 15 〉	통과 (479.87ms, 87.3MB)
 * 테스트 16 〉	통과 (55.19ms, 89.7MB)
 * 테스트 17 〉	통과 (417.32ms, 78.1MB)
 * 테스트 18 〉	통과 (263.77ms, 93.6MB)
 * 테스트 19 〉	통과 (254.64ms, 74.8MB)
 * 테스트 20 〉	통과 (246.58ms, 86.2MB)
 * 테스트 21 〉	통과 (173.13ms, 110MB)
 * 테스트 22 〉	통과 (126.53ms, 84.3MB)
 * 테스트 23 〉	통과 (165.60ms, 93.6MB)
 */
public class Ex기둥과보설치v2 {
    static class Point {
        int x;
        int y;
        int a; // 기둥 : 0, 보 : 1

        public Point(int x, int y, int a) {
            this.x = x;
            this.y = y;
            this.a = a;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getA() {
            return a;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y && a == point.a;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, a);
        }
    }

    static class Solution {
        public boolean canBuildPillar(Point now, ArrayList<Point> answer) {
            boolean can = false;
            if (now.getY() == 0) {
                can = true;
            }
            else {
                for (int j = 0; j < answer.size(); j++) {
                    Point tmp = answer.get(j);
                    if (tmp.getX() == now.getX() && tmp.getY() == now.getY()-1 && tmp.getA() == 0) {
                        can = true;
                    }
                    if (tmp.getX() == now.getX() && tmp.getY() == now.getY() && tmp.getA() == 1) {
                        can = true;
                    }
                    if (tmp.getX() == now.getX()-1 && tmp.getY() == now.getY() && tmp.getA() == 1) {
                        can = true;
                    }
                }
            }
            return can;
        }
        public boolean canBuildBeam(Point now, ArrayList<Point> answer) {
            boolean can = false;
            boolean left = false;
            boolean right = false;

            for (int j = 0; j < answer.size(); j++) {
                Point tmp = answer.get(j);
                if (tmp.getX() == now.getX()-1 && tmp.getY() == now.getY() && tmp.getA() == 1) {
                    left = true;
                }
                if (tmp.getX() == now.getX()+1 && tmp.getY() == now.getY() && tmp.getA() == 1) {
                    right = true;
                }
                if (tmp.getX() == now.getX() && tmp.getY() == now.getY()-1 && tmp.getA() == 0) {
                    can = true;
                }
                if (tmp.getX() == now.getX()+1 && tmp.getY() == now.getY()-1 && tmp.getA() == 0) {
                    can = true;
                }
            }
            if (!can) can = left && right;

            return can;
        }
        public boolean check(ArrayList<Point> answer) {
            boolean ret = true;
            for (int i = 0; i < answer.size(); i++) {
                boolean can = false;
                Point now = answer.get(i);
                if (now.getA() == 0) { // 기둥
                    can = canBuildPillar(now, answer);
                }
                else if (now.getA() == 1) { // 보
                    can = canBuildBeam(now, answer);
                }
                ret = ret && can;
            }
            return ret;
        }
        public int[][] solution(int n, int[][] build_frame) {
            ArrayList<Point> answer = new ArrayList<>();

            for (int i = 0; i < build_frame.length; i++) {
                int x = build_frame[i][0];
                int y = build_frame[i][1];
                int a = build_frame[i][2];
                int b = build_frame[i][3];
                Point next = new Point(x, y, a);
                if (b == 0) { // 삭제
                    int idx = -1;
                    for (int j = 0; j < answer.size(); j++) {
                        if (answer.get(j).equals(next)) {
                           idx = j;
                           break;
                        }
                    }
                    if (idx != -1) {
                        Point erased = answer.get(idx);
                        answer.remove(idx);
                        if (!check(answer)) {
                            answer.add(erased);
                        }
                    }
                }
                else if (b == 1) { // 설치
                    answer.add(next);
                    if (!check(answer)) {
                        answer.remove(next);
                    }
                }
            }

            int[][] arr = new int[answer.size()][3];
            for (int i = 0; i < answer.size(); i++) {
                arr[i][0] = answer.get(i).getX();
                arr[i][1] = answer.get(i).getY();
                arr[i][2] = answer.get(i).getA();
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
