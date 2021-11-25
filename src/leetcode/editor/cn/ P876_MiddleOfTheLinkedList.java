//给定一个头结点为 head 的非空单链表，返回链表的中间结点。 
//
// 如果有两个中间结点，则返回第二个中间结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,2,3,4,5]  1,1 2,3 3,5
//输出：此列表中的结点 3 (序列化形式：[3,4,5])
//返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
//注意，我们返回了一个 ListNode 类型的对象 ans，这样：
//ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = 
//NULL.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,3,4,5,6]  1,1 2,3 3,5
//输出：此列表中的结点 4 (序列化形式：[4,5,6])
//由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
// 
//
// 
//
// 提示： 
//
// 
// 给定链表的结点数介于 1 和 100 之间。 
// 
// Related Topics 链表 双指针 
// 👍 440 👎 0

 
package leetcode.editor.cn;
 
//链表的中间结点
 
class P876_MiddleOfTheLinkedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P876_MiddleOfTheLinkedList().new Solution();
	 }

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class ListNode{
	int val;
	ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

	//双指针 快慢指针
    public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode quick = head;
		while (quick!=null){
			if (quick.next!=null){
				slow = slow.next;
				quick = quick.next;
			}
			quick = quick.next;
		}
		return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}