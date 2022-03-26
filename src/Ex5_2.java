import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex5_2 {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(5);
        q.offer(2);
        q.offer(3);
        q.offer(8);

        System.out.println(q.peek());

        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }

    }
}
