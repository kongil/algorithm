import java.util.Scanner;

public class Ex5_4 {
    public static void recursiveFunction(int i) {
        if (i == 100) return;
        System.out.println(i + "번쨰 재귀를 시작합니다.");
        recursiveFunction(i+1);
        System.out.println(i + "번쨰 재귀를 종료합니다.");
    }
    public static void main(String[] args) {
        recursiveFunction(1);
    }
}
