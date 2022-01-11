//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 1137 👎 0

 
package leetcode.editor.cn;
 
//二叉树的层序遍历

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class P102_BinaryTreeLevelOrderTraversal{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P102_BinaryTreeLevelOrderTraversal().new Solution();
		 System.out.println("3".indexOf("0")>-1);
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
class Solution {
	/**
	 * 二叉树的层序遍历
	 * @param root
	 * @return
	 */
    public List<List<Integer>> levelOrder(TreeNode root) {
    	if (root == null){
    		return new LinkedList<List<Integer>>();
		}
    	List<List<Integer>> result = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()){
			List<Integer> res = new LinkedList<>();
			int size = queue.size();
			int i = 0;
			while (i<size){
				TreeNode node = queue.poll();
				res.add(node.val); // 自动装箱
				if (node.left!=null){
					queue.add(node.left);
				}
				if (node.right!=null){
					queue.add(node.right);
				}
				i++;
			}
			result.add(res);
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}