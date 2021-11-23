//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1610 👎 0

 
package leetcode.editor.cn;
 
//对称二叉树

import class06.BinaryTree2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class P101_SymmetricTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P101_SymmetricTree().new Solution();
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

public class TreeNode {
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

class ReturnType{
	boolean isSymmetric;
}

class Solution {
    public boolean isSymmetric(TreeNode node) {

//    	if (node == null){
//    		return true;
//		}
//    	boolean leftRes = isSymmetric(node.left);
//		boolean rightRes = isSymmetric(node.right);
//		if (!leftRes || !rightRes){
//			return false;
//		}
//		if ((node.left==null && node.right!=null) || node.left!=null&& node.right==null){
//			return false;
//		}
//		if (node.left!=null && node.right!=null && node.left.val!=node.right.val) {
//			return false;
//		}
//		return true;

		Queue<TreeNode> queue = new LinkedList<>();
		List<TreeNode> list = new ArrayList<>();
		queue.add(node);
		while (!queue.isEmpty()){
			TreeNode head = queue.poll();
			System.out.println(head.val);
			list.add(head);
			queue.add(head.left==null?new TreeNode(0):head.left);
			queue.add(head.right==null?new TreeNode(0):head.right);
		}
		return false;


	}
}
//leetcode submit region end(Prohibit modification and deletion)

}