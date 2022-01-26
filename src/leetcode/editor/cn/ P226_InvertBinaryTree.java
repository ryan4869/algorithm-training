//翻转一棵二叉树。 
//
// 示例： 
//
// 输入： 
//
//     4
//   /   \
//  2     7
// / \   / \
//1   3 6   9 
//
// 输出： 
//
//     4
//   /   \
//  7     2
// / \   / \
//9   6 3   1 
//
// 备注: 
//这个问题是受到 Max Howell 的 原问题 启发的 ： 
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。 
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 
// 👍 1146 👎 0

 
package leetcode.editor.cn;
 
//翻转二叉树

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class P226_InvertBinaryTree{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P226_InvertBinaryTree().new Solution();
	 }

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
	/**
	 * 层序遍历 每次出队列翻转左右孩子
	 * @param root
	 * @return
	 */
    public TreeNode invertTree(TreeNode root) {
    	if (root == null){
    		return root;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()){
			int size = queue.size();
			for (int i = 0; i <size ; i++) {
				TreeNode pop = queue.poll();
				swap(pop);
				if (pop.left != null){
					queue.add(pop.left);
				}
				if (pop.right != null){
					queue.add(pop.right);
				}
			}
		}
		return root;
    }

    public void swap(TreeNode node){
    	TreeNode temp = node.left;
    	node.left = node.right;
    	node.right = temp;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}