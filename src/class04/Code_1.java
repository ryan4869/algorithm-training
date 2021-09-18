package class04;

public class Code_1 {

    public class Node{
        int val;
        Node next;

        Node(int x){
            this.val = x;
            this.next = null;
        }
    }

    public static Node noLoop(Node head1, Node head2){
        if (head1==null || head2==null){
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int count = 0;
        while(cur1.next!=null){
            count++;
            cur1 = cur1.next;
        }
        while (cur2.next!=null){
            count--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2){
            return null;
        }
        cur1 = count>0?head1:head2;
        cur2 = cur1==head1?head2:head1;
        count = Math.abs(count);
        while(count!=0){
            cur1 = cur1.next;
            count--;
        }
        while (cur1!=null && cur2!=null){
            if (cur1 == cur2){
                return cur1;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return null;
    }

    public static Node getLoopNode(Node head){
        if(head==null || head.next==null ||head.next.next==null){
            return null;
        }
        Node n1 = head.next;
        Node n2 = head.next.next;
        while (n1!=n2){
            if (n2.next==null || n2.next.next==null){
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        n2 = head;
        while (n1!=n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static Node bothLoop(Node head1,Node head2){
        Node node1 = getLoopNode(head1);
        Node node2 = getLoopNode(head2);
        if (node1==node2){
            Node node = noLoop(head1, head2);
            return node;
        }else {
            Node n1 = node1;
            Node n2 = node2;
            while (n1!=n2 && n1.next!=node1){
                n1 = n1.next;
            }
            if (n1.next == node1){
                return null;
            }
            return n1;
        }
    }

}
