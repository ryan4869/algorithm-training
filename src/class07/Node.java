package class07;

import java.util.LinkedList;
import java.util.List;

public class Node {

    int in; // 入度
    int out; // 出度
    int value;
    List<Node> next;
    List<Edge> edges;

    public Node(int in, int out) {
        this.in = in;
        this.out = out;
        this.next = new LinkedList<>();
        this.edges = new LinkedList<>();
    }
}
