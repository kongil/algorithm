import java.util.*;

public class GraphEx3 {
    static class Point {
        int x;
        int y;
        int dir;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public boolean equals(Object o) {
            return x == ((Point)o).x && y == ((Point)o).y;
        }
    }
    static class Solution {
        public int solution(int[] arrows) {
            int answer = 0;
            Point now = new Point(0, 0);
            int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
            int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
            // 점과 그점이 속한 선
            HashMap<Point, ArrayList<Point>> visited = new HashMap<>();
            visited.put(now, makeEdgeList(now));

            for (int dir : arrows) {
                Point next = new Point(now.getX() + dx[dir], now.getY() + dy[dir]);

                // 재방문 && 간선을 처음 통과하는 경우
                if (visited.containsKey(next) && !(visited.get(next).contains(now))) {
                    visited.get(next).add(now);
                    visited.get(now).add(next);
                    answer++;
                }
                //처음 방문
                else if (!visited.containsKey(next)){
                    visited.put(next, makeEdgeList(next));

                    if (visited.get(now) == null) {
                        visited.put(now, makeEdgeList(next));
                    } else {
                        visited.get(now).add(next);
                    }
                }

                // 이동
                now = next;
            }

            return answer;
        }
        public ArrayList<Point> makeEdgeList(Point point) {
            ArrayList<Point> edge = new ArrayList<>();
            edge.add(point);
            return edge;
        }
    }

    public static void main(String[] args) {
        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
        Solution solution = new Solution();
        System.out.println(solution.solution(arrows));
    }
}
