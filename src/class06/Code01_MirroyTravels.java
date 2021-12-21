package class06;

public class Code01_MirroyTravels {

    public static void morris(Node node){
        Node cur = node;
        if (cur.left!=null){
            Node rightest = cur.left;
            while (rightest.right!=null){
                rightest = rightest.right;
            }
            rightest.next = cur;
        }
    }
}
