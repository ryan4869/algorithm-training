package medium;

import org.w3c.dom.NodeList;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class reverse_linked_list_ii {

    public final static int N = 5;

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null){

        }
        // 0 1 2 3 4 5
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode succ = head.next.next;
        while (cur!=null){
            cur.next = pre;
            pre.next = null;
            pre = cur;
            cur = succ;
            if (succ!=null){
                succ = succ.next;
            }

        }


        return head;
    }

    public static void main(String[] args) {

        ListNode arr[] = new ListNode[N];
        for (int i = 0; i < N; i++) {
            ListNode node = new ListNode(i);
            arr[i] = node;
        }
        for (int i = 0; i < N-1; i++) {
            arr[i].next = arr[i+1];
        }
        ListNode node = reverseBetween(arr[0], 0, N-1 );
        while (node!=null){
            System.out.println(node.val);
            node = node.next;
        }

    }
}
