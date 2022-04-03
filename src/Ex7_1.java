import java.util.*;

public class Ex7_1 {
    public static int sequentialSearch(String target, List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(target)) {
                return i+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String tmp = sc.next();
            list.add(tmp);
        }

        System.out.println(sequentialSearch(s, list));

    }
}
