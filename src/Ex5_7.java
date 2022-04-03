
import java.util.*;

class Node2 {
    int index;
    int distance;

    public Node2(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public void show() {
        System.out.println("(" + index + ", " + this.distance + ")");
    }
}

public class Ex5_7 {
    public static ArrayList<ArrayList<Node2>> graph = new ArrayList<ArrayList<Node2>>();

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            graph.add(new ArrayList<Node2>());
        }

        graph.get(0).add(new Node2(1, 7));
        graph.get(0).add(new Node2(2, 5));

        graph.get(1).add(new Node2(0, 7));

        graph.get(2).add(new Node2(0, 5));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                graph.get(i).get(j).show();
            }
            System.out.println();
        }
    }
}
