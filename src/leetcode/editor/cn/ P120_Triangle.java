//给定一个三角形 triangle ，找出自顶向下的最小路径和。 
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -104 <= triangle[i][j] <= 104 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 
// 👍 909 👎 0

 
package leetcode.editor.cn;
 
//三角形最小路径和

import java.util.List;

class P120_Triangle{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P120_Triangle().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)

	class Solution {
		Integer[][] memo;
		public int minimumTotal(List<List<Integer>> triangle) {
			memo = new Integer[triangle.size()][triangle.size()];
			return  dfs(triangle, 0, 0);
		}

		private int dfs(List<List<Integer>> triangle, int i, int j) {
			if (i == triangle.size()) {
				return 0;
			}
			if (memo[i][j] != null) {
				return memo[i][j];
			}
			return memo[i][j] = Math.min(dfs(triangle, i + 1, j), dfs(triangle, i + 1, j + 1)) + triangle.get(i).get(j);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}