//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 2072 👎 0

 
package leetcode.editor.cn;
 
//合并两个有序链表
 
class P21_MergeTwoSortedLists{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P21_MergeTwoSortedLists().new Solution();
	 }
	 public class ListNode {
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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		/**
		// 带头节点的链表
    	ListNode prehead = new ListNode(-1);
    	ListNode prev = prehead;
    	while (list1!=null && list2!=null){
    		if (list1.val <= list2.val){
				prev.next = list1;
				list1 = list1.next;
			}
    		else {
				prev.next = list2;
				list2 = list2.next;
			}
    		prev = prev.next;
		}
    	if (list1!=null){
			prev.next=list1;
		}
    	if (list2!=null){
			prev.next=list2;
		}
    	return prehead.next!=null?prehead.next:null;
    }
		 **/

		// 递归解法
		ListNode prehead = new ListNode(-1);
		ListNode prev = prehead;
		process(prev, list1, list2);
		return prehead.next;

	}

	public ListNode process(ListNode list, ListNode list1, ListNode list2) {
		if (list1 == null){
			list.next = list2;
			return list;
		}
		if (list2 == null){
			list.next = list1;
			return list;
		}
		if (list1.val<=list2.val){
			list.next = list1;
			return process(list.next,list1.next,list2);
		}else {
			list.next = list2;
			return process(list.next,list1,list2.next);
		}
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}