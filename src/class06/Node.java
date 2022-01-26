package class06;

public class Node implements Comparable{
    int val;
    Node left;
    Node right;
    Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right,Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Node){
            return ((Node) o).val - this.val; //降序
        }
        throw new RuntimeException("Object cast exception");
    }
}
