//给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。 
//
// 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点
//。 
//
// 示例 1: 
//
// 
//输入: 
//	Tree 1                     Tree 2                  
//          1                         2                             
//         / \                       / \                            
//        3   2                     1   3                        
//       /                           \   \                      
//      5                             4   7                  
//输出: 
//合并后的树:
//	     3
//	    / \
//	   4   5
//	  / \   \ 
//	 5   4   7
// 
//
// 注意: 合并必须从两个树的根节点开始。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 816 👎 0

 
package leetcode.editor.cn;
 
//合并二叉树

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class P617_MergeTwoBinaryTrees{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P617_MergeTwoBinaryTrees().new Solution();
//	 	 TreeNode root1 = new TreeNode(1);
//	 	 root1.left = new TreeNode(3);
//	 	 root1.right = new TreeNode(2);
//	 	 root1.left.left = new TreeNode(5);
//
//	 	 TreeNode root2 = new TreeNode(2);
//	 	 root2.left = new TreeNode(1);
//	 	 root2.right = new TreeNode(3);
//	 	 root2.left.right = new TreeNode(4);
//	 	 root2.right.right = new TreeNode(7);
//	 	 solution.mergeTrees(root1,root2);

	 }
	 public static class TreeNode{
	 	int val;
	 	TreeNode left;
	 	TreeNode right;

		 public TreeNode() {
		 }

		 public TreeNode(int val) {
			 this.val = val;
		 }

		 public TreeNode(int val, TreeNode left, TreeNode right) {
			 this.val = val;
			 this.left = left;
			 this.right = right;
		 }
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    	if (root1 == null){
    		return root2;
		}
    	if (root2 == null){
    		return root1;
		}
    	TreeNode root = new TreeNode(root1.val+root2.val);
		Queue<TreeNode> queue1 = new LinkedList<>();
		queue1.add(root1);
		Queue<TreeNode> queue2 = new LinkedList<>();
		queue2.add(root2);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue1.isEmpty() && !queue2.isEmpty()){
			TreeNode node1 = queue1.poll();
			TreeNode node2 = queue2.poll();
			TreeNode node = queue.poll();
			if (node1.left!=null && node2.left!=null){
				node.left = new TreeNode(node1.left.val+node2.left.val);
				queue1.add(node1.left);
				queue2.add(node2.left);
				queue.add(node.left);
			}else if (node1.left == null && node2.left != null){
				node.left = node2.left;
//				queue1.add(new TreeNode(0));
//				queue2.add(node2.left);
//				queue.add(node.left);
			}else if (node2.left == null && node1.left != null){
				node.left = node1.left;
//				queue1.add(node1.left);
//				queue2.add(new TreeNode(0));
//				queue.add(node.left);
			}
			if (node1.right!=null && node2.right!=null){
				node.right = new TreeNode(node1.right.val+node2.right.val);
				queue1.add(node1.right);
				queue2.add(node2.right);
				queue.add(node.right);
			}else if (node1.right == null && node2.right!=null){
				node.right = node2.right;
//				queue1.add(new TreeNode(0));
//				queue2.add(node2.right);
//				queue.add(node.right);
			}else if (node2.right == null && node1.right!=null){
				node.right = node1.right;
//				queue1.add(node1.right);
//				queue2.add(new TreeNode(0));
//				queue.add(node.right);
			}
		}
		return root;
    }



}
//leetcode submit region end(Prohibit modification and deletion)

	public TreeNode BFS(TreeNode root){
		if (root == null){
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()){
			TreeNode node = queue.poll();
			System.out.println(node.val);
			if (node.left!=null){
				queue.add(node.left);
			}
			if (node.right!=null){
				queue.add(node.right);
			}
		}
		return root;
	}
}