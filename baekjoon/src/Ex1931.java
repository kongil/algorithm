import java.util.*;

class Meet implements Comparable<Meet> {
    int start;
    int end;

    public Meet(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Meet{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    @Override
    public int compareTo(Meet o) {
        if ((this.end - o.end) != 0)
            return this.end - o.end;
        else
            return this.start - o.start;
    }
}

public class Ex1931 {
    public static void main(String[] args) {
        PriorityQueue<Meet> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            Meet meet = new Meet(start, end);
            pq.add(meet);
        }

        int maxEnd = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            Meet meet = pq.poll();
            if (meet.getStart() >= maxEnd) {
                maxEnd = meet.getEnd();
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
