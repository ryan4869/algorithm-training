//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//    1
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
//    1
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

import java.util.*;

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
	/**
	 * 乍一看无从下手，但用递归其实很好解决。
	 * 根据题目的描述，镜像对称，就是左右两边相等，也就是左子树和右子树是相当的。
	 * 注意这句话，左子树和右子相等，也就是说要递归的比较左子树和右子树。
	 * 我们将根节点的左子树记做 left，右子树记做 right。比较 left 是否等于 right，不等的话直接返回就可以了。
	 * 如果相当，比较 left 的左节点和 right 的右节点，再比较 left 的右节点和 right 的左节点
	 * 比如看下面这两个子树(他们分别是根节点的左子树和右子树)，能观察到这么一个规律：
	 * 左子树 22 的左孩子 == 右子树 22 的右孩子
	 * 左子树 22 的右孩子 == 右子树 22 的左孩子
	 *
	 * 作者：wang_ni_ma
	 * 链接：https://leetcode-cn.com/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/
	 * 来源：力扣（LeetCode）
	 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 * @param node
	 * @return
	 */
    public boolean isSymmetricTree(TreeNode node) {
    	// 递归实现
		/**
		 * 左子树根节点 = 右子树根节点
		 * 左子树左孩子 = 右子树右孩子
		 * 左子树右孩子 = 右子树左孩子
		 */
		if (node == null){
			return true;
		}
		return process(node.left,node.right);
	}

	public boolean process(TreeNode left,TreeNode right){
    	if (left == null && right == null){
    		return true;
		}
    	if (left == null || right == null){
    		return false;
		}
    	if (left.val != right.val){
    		return false;
		}
    	return process(left.left, right.right) && process(left.right,right.left);

	}

	/**
	 * 回想下递归的实现：
	 * 当两个子树的根节点相等时，就比较:
	 * 左子树的 left 和 右子树的 right，这个比较是用递归实现的。
	 * 现在我们改用队列来实现，思路如下：
	 * 首先从队列中拿出两个节点(left 和 right)比较
	 * 将 left 的 left 节点和 right 的 right 节点放入队列
	 * 将 left 的 right 节点和 right 的 left 节点放入队列
	 * 时间复杂度是 O(n)O(n)，空间复杂度是 O(n)O(n)
	 *
	 * 作者：wang_ni_ma
	 * 链接：https://leetcode-cn.com/problems/symmetric-tree/solution/dong-hua-yan-shi-101-dui-cheng-er-cha-shu-by-user7/
	 * 来源：力扣（LeetCode）
	 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
	 *
	 * @param node
	 * @return
	 */
	public boolean isSymmetric(TreeNode node){
    	// 迭代

		if (node == null || (node.left == null && node.right == null)){
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(node.left);
		queue.add(node.right);
		while (!queue.isEmpty()){
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();
			if (left == null && right == null){
				continue;
			}
			if (left == null || right == null){
				return false;
			}
			if (left.val != right.val){
				return false;
			}

			queue.add(left.left);
			queue.add(right.right);

			queue.add(left.right);
			queue.add(right.left);

		}
		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}