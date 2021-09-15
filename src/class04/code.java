package class04;

public class code {

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

}
