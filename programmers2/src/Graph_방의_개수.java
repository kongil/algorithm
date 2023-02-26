import java.util.*;

public class Graph_방의_개수 {
    static class Solution {

        class Point {
            int x;
            int y;

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Point point = (Point) o;
                return x == point.x && y == point.y;
            }

            @Override
            public int hashCode() {
                return Objects.hash(x, y);
            }
        }

        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

        public List<Point> makeEdgeList(Point p) {
            List<Point> list = new LinkedList<>();
            list.add(p);
            return list;
        }

        public int solution(int[] arrows) {
            int answer = 0;

            Map<Point, List<Point>> visited = new HashMap<>();
            Point now = new Point(0, 0);

            for (int arrow : arrows) {
                for (int i = 0; i < 2; i++) {
                    Point next = new Point(now.x + dx[arrow], now.y + dy[arrow]);

                    if (visited.get(next) != null && !visited.get(next).contains(now)) {
                        visited.get(now).add(next);
                        visited.get(next).add(now);
                        answer++;
                    }
                    else if (visited.get(next) == null){
                        visited.put(next, makeEdgeList(now));
                        if (visited.get(now) == null) {
                            visited.put(now, makeEdgeList(next));
                        }
                        else {
                            visited.get(now).add(next);
                        }
                    }

                    now = next;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
        Solution solution = new Solution();
        System.out.println(solution.solution(arrows));
    }
}
