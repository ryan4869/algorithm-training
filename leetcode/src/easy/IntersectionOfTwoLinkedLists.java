package easy;
/*
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Intersected at '8'
解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。
在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。

 */
public class IntersectionOfTwoLinkedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        int[] listA = {8};
        int[] listB = {4,1,8,4,5};
        ListNode headA = new ListNode(listA[0]);
        ListNode tailA = headA;
        for (int i = 1; i < listA.length; i++) {
            ListNode node = new ListNode(listA[i]);
            tailA.next = node;
            tailA = tailA.next;
        }
        ListNode headB = new ListNode(listB[0]);
        ListNode tailB = headB;
        for (int i = 1; i < listB.length; i++) {
            ListNode node = new ListNode(listB[i]);
            tailB.next = node;
            tailB = tailB.next;
        }
        ListNode intersectionNode = getIntersectionNode(headA, headB);
        if (intersectionNode!=null){
            System.out.println(intersectionNode.val);
        }else {
            System.out.println("null");
        }

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(nodeA.next!=null && nodeB.next!=null){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        int count = 0;
        if (nodeA.next == null){
            while(nodeB.next!=null){
                nodeB = nodeB.next;
                count++;
            }
        }else {
            while(nodeA.next!=null){
                nodeA = nodeA.next;
                count--;
            }
        }
        if (count>0){
            for (int i = 0; i <count ; i++) {
                headB = headB.next;
            }
        }else if (count<0){
            for (int i = 0; i < Math.abs(count); i++) {
                headA = headA.next;
            }
        }
        while (headA!=null && headB!=null){
            if (headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
