import java.util.*;

/**
 * 테스트 1 〉	통과 (1.09ms, 74.3MB)
 * 테스트 2 〉	통과 (3.08ms, 78.6MB)
 * 테스트 3 〉	통과 (2.82ms, 76.4MB)
 * 테스트 4 〉	통과 (6.99ms, 75.8MB)
 * 테스트 5 〉	통과 (34.53ms, 85.9MB)
 * 테스트 6 〉	통과 (149.36ms, 131MB)
 * 테스트 7 〉	통과 (22.72ms, 98.7MB)
 * 테스트 8 〉	통과 (95.54ms, 128MB)
 * 테스트 9 〉	통과 (92.16ms, 141MB)
 */

public class Graph_방의_개수 {
    static class Point {
        int x;
        int y;

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
        /**
         * 1. 방이 생기는 규칙
         * 방문했던 점(point)을 재방문하는 경우, 방이 생성된다.
         * 기존에 이어졌던 점(point)을 재통과하는 경우에는 정점을 재방문해도 방이 생성되지 않는다.
         * 즉, 해당 점을 재방문하고 방문하기 전 출발점이 처음일 때 방이 생긴다. (생기는 방의 갯수 : 1 or 2)
         *
         * 2. 예외 케이스
         * 각 점(point)의 단위가 작아 교차가 발생할 수 있다. 이를 위해 단위를 스케일업 해준다.
         */
        public int solution(int[] arrows) {
            int answer = 0;
            Point now = new Point(0, 0);
            int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
            int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
            // 점과 그 점이 연결된 점들
            Map<Point, List<Point>> visited = new HashMap<>();

            for (int arrow : arrows) {
                for (int i = 0; i < 2; i++) { // 교차점을 위한 스케일업
                    Point next = new Point(now.getX() + dx[arrow], now.getY() + dy[arrow]);

                    // 재방문 && 간선을 처음 통과하는 경우
                    if (visited.containsKey(next) && !(visited.get(next).contains(now))) {
                        visited.get(next).add(now);
                        visited.get(now).add(next);
                        answer++;
                    }
                    // 처음 방문
                    else if (!visited.containsKey(next)) {
                        visited.put(next, makeEdgeList(now));

                        if (visited.get(now) == null) { // 현재 방문점에 대해 이어진 점들이 없는 경우
                            visited.put(now, makeEdgeList(next));
                        } else {                        // 현재 방문점에 대해 이어진 점을 관리하고 있는 경우
                            visited.get(now).add(next);
                        }
                    }

                    // 이동
                    now = next;
                }
            }

            return answer;
        }

        /**
         * 처음 다른 점을 방문할 경우, 이어진 점들을 관리하기 위한 list를 생성한다.
         * @param point
         * @return
         */
        public List<Point> makeEdgeList(Point point) {
            List<Point> edge = new ArrayList<>();
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
