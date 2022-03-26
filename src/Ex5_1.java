import java.util.*;

// stack 사용법
public class Ex5_1 {
    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();

        s.push(5);
        s.push(2);
        s.push(3);
        s.push(4);

        while (!s.empty()) {
            System.out.println(s.peek());
            s.pop();
        }

    }
}
